package com.groupdocs.ui.annotation.resources;

import com.google.common.collect.Lists;
import com.groupdocs.annotation.common.exception.AnnotatorException;
import com.groupdocs.annotation.common.license.License;
import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.FileDescription;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.domain.containers.DocumentInfoContainer;
import com.groupdocs.annotation.domain.containers.FileTreeContainer;
import com.groupdocs.annotation.domain.image.PageImage;
import com.groupdocs.annotation.domain.options.FileTreeOptions;
import com.groupdocs.annotation.domain.options.ImageOptions;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.ui.annotation.annotator.AnnotatorFactory;
import com.groupdocs.ui.annotation.config.AnnotationConfigurationModel;
import com.groupdocs.ui.annotation.entity.request.AnnotateDocumentRequest;
import com.groupdocs.ui.annotation.entity.web.AnnotatedDocumentEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationPageDescriptionEntity;
import com.groupdocs.ui.annotation.importer.Importer;
import com.groupdocs.ui.annotation.util.AnnotationMapper;
import com.groupdocs.ui.annotation.util.SupportedAnnotations;
import com.groupdocs.ui.annotation.util.directory.DirectoryUtils;
import com.groupdocs.ui.annotation.views.Annotation;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.entity.web.UploadedDocumentEntity;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.common.resources.Resources;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.*;
import java.net.UnknownHostException;
import java.util.*;

import static com.groupdocs.ui.annotation.util.DocumentTypesConverter.getDocumentType;
import static javax.ws.rs.core.MediaType.*;

/**
 * AnnotationResources
 *
 * @author Aspose Pty Ltd
 */

@Path(value = "/annotation")
public class AnnotationResources extends Resources {
    private static final Logger logger = LoggerFactory.getLogger(AnnotationResources.class);

    private final AnnotationImageHandler annotationImageHandler;
    private DirectoryUtils directoryUtils;
    private String[] supportedImageFormats = {"bmp", "jpeg", "jpg", "tiff", "tif", "png", "gif", "emf", "wmf", "dwg", "dicom", "djvu"};
    private static final List<String> supportedDiagramFormats = Lists.newArrayList(".vsd", ".vdx", ".vss", ".vsx", ".vst", ".vtx", ".vsdx", ".vdw", ".vstx", ".vssx");

    /**
     * Constructor
     *
     * @param globalConfiguration global configuration object
     * @throws UnknownHostException
     */
    public AnnotationResources(GlobalConfiguration globalConfiguration) throws UnknownHostException {
        super(globalConfiguration);

        // create annotation directories
        directoryUtils = new DirectoryUtils(globalConfiguration.getAnnotation());

        // create annotation application configuration
        AnnotationConfig config = new AnnotationConfig();
        // set storage path
        config.setStoragePath(directoryUtils.getFilesDirectory().getPath());
        // set directory to store annotated documents
        config.getFontDirectories().add(globalConfiguration.getAnnotation().getFontsDirectory());
        try {
            // set GroupDocs license
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable exc) {
            logger.error("Can not verify Annotation license!");
        }
        // initialize total instance for the Image mode
        annotationImageHandler = new AnnotationImageHandler(config);
    }

    /**
     * Get and set annotation page
     *
     * @return html view
     */
    @GET
    public Annotation getView() {
        // initiate index page
        return new Annotation(globalConfiguration, DEFAULT_CHARSET);
    }

    @GET
    @Path(value = "/loadConfig")
    @Produces(APPLICATION_JSON)
    public AnnotationConfigurationModel loadConfig() {
        return AnnotationConfigurationModel.createAnnotationConfiguration(globalConfiguration.getAnnotation(), globalConfiguration.getCommon());
    }

    /**
     * Get files and directories
     *
     * @param fileTreeRequest request's object with specified path
     * @return files and directories list
     */
    @POST
    @Path(value = "/loadFileTree")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public List<FileDescriptionEntity> loadFileTree(FileTreeRequest fileTreeRequest) {
        String relDirPath = fileTreeRequest.getPath();
        // get file list from storage path
        FileTreeOptions fileListOptions = new FileTreeOptions(relDirPath);
        // get temp directory name
        String tempDirectoryName = new com.groupdocs.annotation.domain.config.AnnotationConfig().getTempFolderName();
        try {
            FileTreeContainer fileListContainer = annotationImageHandler.loadFileTree(fileListOptions);

            ArrayList<FileDescriptionEntity> fileList = new ArrayList<>();
            // parse files/folders list
            for (FileDescription fd : fileListContainer.getFileTree()) {
                FileDescriptionEntity fileDescription = new FileDescriptionEntity();
                fileDescription.setGuid(fd.getGuid());
                // check if current file/folder is temp directory or is hidden
                if (tempDirectoryName.toLowerCase().equals(fd.getName()) || new File(fileDescription.getGuid()).isHidden()) {
                    // ignore current file and skip to next one
                    continue;
                } else {
                    // set file/folder name
                    fileDescription.setName(fd.getName());
                }
                // set file type
                fileDescription.setDocType(fd.getDocumentType());
                // set is directory true/false
                fileDescription.setDirectory(fd.isDirectory());
                // set file size
                fileDescription.setSize(fd.getSize());
                // add object to array list
                fileList.add(fileDescription);
            }
            return fileList;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Get document description
     *
     * @return document description
     */
    @POST
    @Path(value = "/loadDocumentDescription")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public AnnotatedDocumentEntity loadDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        try {
            // get/set parameters
            String documentGuid = loadDocumentRequest.getGuid();
            String password = loadDocumentRequest.getPassword();
            ImageOptions imageOptions = new ImageOptions();
            // set password for protected document
            if (!StringUtils.isEmpty(password)) {
                imageOptions.setPassword(password);
            }
            // get document info container
            String fileName = FilenameUtils.getName(documentGuid);
            DocumentInfoContainer documentDescription = annotationImageHandler.getDocumentInfo(fileName, password);

            String fileExtension = StringUtils.lowerCase(FilenameUtils.getExtension(documentGuid));
            String documentType = getCheckedDocumentType(documentDescription.getDocumentType(), fileExtension);
            // check if document contains annotations
            AnnotationInfo[] annotations = getAnnotations(documentGuid, documentType);
            // initiate pages description list
            List<PageImage> pageImages = null;
            if (globalConfiguration.getAnnotation().getPreloadPageCount() == 0) {
                pageImages = annotationImageHandler.getPages(fileName, imageOptions);
            }
            String[] supportedAnnotations = SupportedAnnotations.getSupportedAnnotations(documentType);
            // initiate custom Document description object
            AnnotatedDocumentEntity description = new AnnotatedDocumentEntity();
            description.setGuid(documentGuid);
            description.setSupportedAnnotations(supportedAnnotations);
            // initiate pages description list
            List<PageData> pages = documentDescription.getPages();
            List<AnnotationPageDescriptionEntity> pagesDescriptions = new ArrayList<>(pages.size());
            // get info about each document page
            for (int i = 0; i < pages.size(); i++) {
                PageData pageData = pages.get(i);
                // set current page info for result
                PageImage pageImage = pageImages != null ? pageImages.get(i) : null;
                AnnotationPageDescriptionEntity page = getAnnotationPageDescriptionEntity(pageData, pageImage);
                // set annotations data if document page contains annotations
                if (annotations != null && annotations.length > 0) {
                    page.setAnnotations(AnnotationMapper.instance.mapForPage(annotations, page.getNumber()));
                }
                pagesDescriptions.add(page);
            }
            description.setPages(pagesDescriptions);
            // return document description
            return description;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    private AnnotationPageDescriptionEntity getAnnotationPageDescriptionEntity(PageData pageData, PageImage pageImage) throws IOException {
        AnnotationPageDescriptionEntity page = new AnnotationPageDescriptionEntity();
        page.setHeight(pageData.getHeight());
        page.setWidth(pageData.getWidth());
        page.setNumber(pageData.getNumber());

        if (pageImage != null) {
            byte[] bytes = IOUtils.toByteArray(pageImage.getStream());
            String encodedImage = Base64.getEncoder().encodeToString(bytes);
            page.setData(encodedImage);
        }
        return page;
    }

    private String getCheckedDocumentType(String documentType, String fileExtension) {
        // check if document type is image
        if (Arrays.asList(supportedImageFormats).contains(fileExtension)) {
            documentType = "image";
        } else if (Arrays.asList(supportedDiagramFormats).contains(fileExtension)) {
            documentType = "diagram";
        }
        return documentType;
    }

    /**
     * Get document page
     *
     * @return document page
     */
    @POST
    @Path(value = "/loadDocumentPage")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public AnnotationPageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        try {
            // get/set parameters
            String documentGuid = loadDocumentPageRequest.getGuid();
            int pageNumber = loadDocumentPageRequest.getPage();
            String password = loadDocumentPageRequest.getPassword();
            // set options
            ImageOptions imageOptions = new ImageOptions();
            imageOptions.setPageNumber(pageNumber);
            imageOptions.setCountPagesToConvert(1);
            // set password for protected document
            if (!password.isEmpty()) {
                imageOptions.setPassword(password);
            }
            InputStream document = new FileInputStream(documentGuid);
            List<PageImage> images = annotationImageHandler.getPages(document, imageOptions);
            String fileName = FilenameUtils.getName(documentGuid);
            DocumentInfoContainer documentDescription = annotationImageHandler.getDocumentInfo(fileName, password);
            PageData pageData = documentDescription.getPages().get(pageNumber - 1);

            AnnotationPageDescriptionEntity page = getAnnotationPageDescriptionEntity(pageData, images.get(0));

            // return loaded page object
            return page;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Download document
     *
     * @param documentGuid path to document parameter
     * @param response
     */
    @GET
    @Path(value = "/downloadDocument")
    @Produces(APPLICATION_OCTET_STREAM)
    public void downloadDocument(@QueryParam("path") String documentGuid,
                                 @Context HttpServletResponse response) {
        // download the file
        downloadFile(response, documentGuid);
    }

    /**
     * Upload document
     *
     * @param inputStream file content
     * @param fileDetail  file description
     * @param documentUrl url for document
     * @param rewrite     flag for rewriting file
     * @return uploaded document object (the object contains uploaded document guid)
     */
    @POST
    @Path(value = "/uploadDocument")
    @Produces(APPLICATION_JSON)
    @Consumes(MULTIPART_FORM_DATA)
    public UploadedDocumentEntity uploadDocument(@FormDataParam("file") InputStream inputStream,
                                                 @FormDataParam("file") FormDataContentDisposition fileDetail,
                                                 @FormDataParam("url") String documentUrl,
                                                 @FormDataParam("rewrite") Boolean rewrite) {
        // upload file
        String pathname = uploadFile(documentUrl, inputStream, fileDetail, rewrite, null);
        // create response
        UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
        uploadedDocument.setGuid(pathname);
        return uploadedDocument;

    }

    @Override
    protected String getStoragePath(Map<String, Object> params) {
        return globalConfiguration.getAnnotation().getFilesDirectory();
    }

    /**
     * Annotate document
     *
     * @param annotateDocumentRequest
     * @return annotated document info
     */
    @POST
    @Path(value = "/annotate")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public AnnotatedDocumentEntity annotate(AnnotateDocumentRequest annotateDocumentRequest) {
        AnnotatedDocumentEntity annotatedDocument = new AnnotatedDocumentEntity();
        try {
            String documentGuid = annotateDocumentRequest.getGuid();
            String documentType = getCheckedDocumentType(annotateDocumentRequest.getDocumentType(), FilenameUtils.getExtension(documentGuid));
            List<AnnotationInfo> annotations = getAnnotationInfos(annotateDocumentRequest, documentType);

            InputStream file = annotateDocument(documentGuid, documentType, annotations);
            if (annotateDocumentRequest.getPrint()) {
                List<AnnotationPageDescriptionEntity> annotatedPages = getAnnotatedPages(annotateDocumentRequest.getPassword(), file);
                annotatedDocument.setPages(annotatedPages);
            } else {
                try (OutputStream fileStream = new FileOutputStream(documentGuid)) {
                    IOUtils.copyLarge(file, fileStream);
                    annotatedDocument.setGuid(documentGuid);
                }
            }
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
        return annotatedDocument;
    }

    private InputStream annotateDocument(String documentGuid, String documentType, List<AnnotationInfo> annotations) throws FileNotFoundException {
        InputStream file = annotationImageHandler.removeAnnotationStream(new FileInputStream(documentGuid));
        // check if annotations array contains at least one annotation to add
        if (annotations.size() > 0) {
            // Add annotation to the document
            int type = getDocumentType(documentType);
            return annotationImageHandler.exportAnnotationsToDocument(file, annotations, type);
        }
        return file;
    }

    private List<AnnotationInfo> getAnnotationInfos(AnnotateDocumentRequest annotateDocumentRequest, String documentType) {
        AnnotationDataEntity[] annotationsData = annotateDocumentRequest.getAnnotationsData();
        // get document info - required to get document page height and calculate annotation top position
        DocumentInfoContainer documentInfo = annotationImageHandler.getDocumentInfo(new File(annotateDocumentRequest.getGuid()).getName(), annotateDocumentRequest.getPassword());
        List<AnnotationInfo> annotations = new ArrayList<>();
        for (AnnotationDataEntity annotationData : annotationsData) {
            // create annotator
            PageData pageData = documentInfo.getPages().get(annotationData.getPageNumber() - 1);
            // add annotation, if current annotation type isn't supported by the current document type it will be ignored
            try {
                annotations.add(AnnotatorFactory.createAnnotator(annotationData, pageData).getAnnotationInfo(documentType));
            } catch (Exception ex) {
                throw new TotalGroupDocsException(ex.getMessage(), ex);
            }
        }
        return annotations;
    }

    /**
     * Annotate document with annotations and download result without saving
     *
     * @return annotated document info
     */
    @POST
    @Path(value = "/downloadAnnotated")
    @Consumes(APPLICATION_JSON)
    public void downloadAnnotated(AnnotateDocumentRequest annotateDocumentRequest, @Context HttpServletResponse response) {
        AnnotationDataEntity[] annotationsData = annotateDocumentRequest.getAnnotationsData();
        if (annotationsData == null || annotationsData.length == 0) {
            throw new IllegalArgumentException("Annotations data is empty");
        }

        // get document path
        String fileName = FilenameUtils.getName(annotateDocumentRequest.getGuid());
        // set response content info
        fillResponseHeaderDisposition(response, fileName);

        long length;
        try (InputStream inputStream = annotateByStream(annotateDocumentRequest);
             ServletOutputStream outputStream = response.getOutputStream()) {
            // download the document
            length = IOUtils.copyLarge(inputStream, outputStream);
        } catch (Exception ex) {
            logger.error("Exception in downloading document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }

        addFileDownloadHeaders(response, fileName, length);
    }

    private InputStream annotateByStream(AnnotateDocumentRequest annotateDocumentRequest) {
        String documentGuid = annotateDocumentRequest.getGuid();
        String documentType = getCheckedDocumentType(annotateDocumentRequest.getDocumentType(), FilenameUtils.getExtension(documentGuid));
        List<AnnotationInfo> annotations = getAnnotationInfos(annotateDocumentRequest, documentType);
        try {
            return annotateDocument(documentGuid, documentType, annotations);
        } catch (FileNotFoundException ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * Get pages images of annotated file
     *
     * @param password    password for the file
     * @param inputStream stream of annotated file
     * @return list of pages
     * @throws IOException
     */
    protected List<AnnotationPageDescriptionEntity> getAnnotatedPages(String password, InputStream inputStream) throws IOException {
        ImageOptions imageOptions = new ImageOptions();
        // set password for protected document
        if (!password.isEmpty()) {
            imageOptions.setPassword(password);
        }
        List<PageImage> pages = annotationImageHandler.getPages(inputStream, imageOptions);
        List<AnnotationPageDescriptionEntity> pagesDescriptions = new ArrayList<>(pages.size());
        for (PageImage pageImage : pages) {
            byte[] bytes = IOUtils.toByteArray(pageImage.getStream());
            String encodedImage = Base64.getEncoder().encodeToString(bytes);
            AnnotationPageDescriptionEntity page = new AnnotationPageDescriptionEntity();
            page.setData(encodedImage);

            pagesDescriptions.add(page);
        }
        return pagesDescriptions;
    }

    /**
     * Get all annotations from the document
     *
     * @param documentGuid
     * @param documentType
     * @return array of the annotations
     */
    private AnnotationInfo[] getAnnotations(String documentGuid, String documentType) {
        try (FileInputStream documentStream = new FileInputStream(documentGuid)) {
            int docType = getDocumentType(documentType);
            return new Importer(documentStream, annotationImageHandler).importAnnotations(docType);
        } catch (AnnotatorException annotatorException) {
            logger.error("Exception while extract annotations from file {}: {}", FilenameUtils.getName(documentGuid), annotatorException.getCause().getLocalizedMessage());
            return new AnnotationInfo[0];
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

}