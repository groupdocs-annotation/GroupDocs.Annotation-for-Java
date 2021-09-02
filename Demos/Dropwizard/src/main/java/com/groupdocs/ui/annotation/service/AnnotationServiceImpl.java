package com.groupdocs.ui.annotation.service;

import com.groupdocs.annotation.license.License;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.IDocumentInfo;
import com.groupdocs.annotation.exceptions.AnnotatorException;
import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.options.LoadOptions;
import com.groupdocs.annotation.options.PreviewFormats;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.annotation.options.export.SaveOptions;
import com.groupdocs.annotation.options.pagepreview.CreatePageStream;
import com.groupdocs.annotation.options.pagepreview.PreviewOptions;
import com.groupdocs.ui.annotation.annotator.AnnotatorFactory;
import com.groupdocs.ui.annotation.annotator.BaseAnnotator;
import com.groupdocs.ui.annotation.config.AnnotationConfiguration;
import com.groupdocs.ui.annotation.entity.web.AnnotatedDocumentEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationPostedDataEntity;
import com.groupdocs.ui.annotation.entity.web.PageDataDescriptionEntity;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.annotation.util.AnnotationMapper;
import com.groupdocs.ui.annotation.util.DocumentTypesConverter;
import com.groupdocs.ui.annotation.util.SupportedAnnotations;
import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

public class AnnotationServiceImpl implements AnnotationService {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationServiceImpl.class);
    private final List<String> SupportedImageFormats = new ArrayList<>();
    
    private GlobalConfiguration globalConfiguration;

    private AnnotationConfiguration annotationConfiguration;

    private final List<PageDataDescriptionEntity> annotationPageDescriptionEntityList = new ArrayList<>();

    public AnnotationServiceImpl(GlobalConfiguration globalConfiguration) {
    	this.annotationConfiguration = globalConfiguration.getAnnotation();
        this.globalConfiguration = globalConfiguration;
        try {
            SupportedImageFormats.add(".bmp");
            SupportedImageFormats.add(".jpeg");
            SupportedImageFormats.add(".jpg");
            SupportedImageFormats.add(".tiff");
            SupportedImageFormats.add(".tif");
            SupportedImageFormats.add(".png");
            SupportedImageFormats.add(".dwg");
            SupportedImageFormats.add(".dcm");
            SupportedImageFormats.add(".dxf");
        
            // set GroupDocs license
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable exc) {
            logger.error("Can not verify Annotation license!");
        }
    }

    @Override
    public GlobalConfiguration getGlobalConfiguration() {
        return globalConfiguration;
    }

    @Override
    public AnnotationConfiguration getAnnotationConfiguration() {
        return annotationConfiguration;
    }

    @Override
    public List<FileDescriptionEntity> getFileList(FileTreeRequest fileTreeRequest) {
        String path = fileTreeRequest.getPath();
        if (StringUtils.isEmpty(path)) {
            path = annotationConfiguration.getFilesDirectory();
        }
        try {
            File directory = new File(path);
            List<File> filesList = Arrays.asList(directory.listFiles());

            List<FileDescriptionEntity> fileList = getFileDescriptionEntities(filesList);
            return fileList;
        } catch (Exception ex) {
            logger.error("Exception in getting file list", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    public List<FileDescriptionEntity> getFileDescriptionEntities(List<File> filesList) {
        List<FileDescriptionEntity> fileList = new ArrayList<>();
        for (File file : filesList) {
            String guid = file.getAbsolutePath();
            String extension = FilenameUtils.getExtension(guid);
            if (file.isDirectory() || (!StringUtils.isEmpty(extension))) {
                FileDescriptionEntity fileDescription = new FileDescriptionEntity();
                fileDescription.setGuid(guid);
                fileDescription.setName(file.getName());
                fileDescription.setDirectory(file.isDirectory());
                fileDescription.setSize(file.length());
                fileList.add(fileDescription);
            }
        }
        return fileList;
    }

    @Override
    public AnnotatedDocumentEntity getDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        try {
            return loadDocument(
                loadDocumentRequest, 
                annotationConfiguration.getPreloadPageCount() == 0
            );
        } catch (Throwable ex) {
            throw new TotalGroupDocsException(ex.getMessage());
        }
    }
    
    public final AnnotatedDocumentEntity loadDocument(LoadDocumentRequest loadDocumentRequest, boolean loadAllPages) {
        Annotator annotator = null;
        AnnotatedDocumentEntity description = new AnnotatedDocumentEntity();
        String guid = loadDocumentRequest.getGuid();
        String password = loadDocumentRequest.getPassword();
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);
        
        try {
            annotator = new Annotator(guid, loadOptions);

            IDocumentInfo info = annotator.getDocument().getDocumentInfo();
            List<AnnotationBase> annotations = annotator.get();

            description.setGuid(loadDocumentRequest.getGuid());

            String documentType = "";
            if (info.getFileType() != null) {
                documentType = SupportedImageFormats.contains(info.getFileType().getExtension()) ? "image" : info.getFileType().toString();
            } else {
                documentType = "Portable Document Format";
            }

            description.supportedAnnotations = SupportedAnnotations.getSupportedAnnotations(documentType);

            List<String> pagesContent = new ArrayList<>();

            if (loadAllPages) {
                pagesContent = getAllPagesContent(password, guid, info);
            }
            for (int i = 0; i < info.getPageCount(); i++) {
                PageDataDescriptionEntity page = new PageDataDescriptionEntity();
                page.setNumber(i + 1);
                page.setHeight(info.getPagesInfo().get(i).getHeight());
                page.setWidth(info.getPagesInfo().get(i).getWidth());

                if (annotations != null && annotations.size() > 0) {                   
                    page.setAnnotations(AnnotationMapper.mapForPage(annotations, i + 1, info.getPagesInfo().get(i)));
                }

                if (pagesContent.size() > 0) {
                    page.setData(pagesContent.get(i));
                }                
                description.getPages().add(page);
            }
        } finally {
            if (annotator != null) {
                annotator.dispose();
            }
        }

        description.setGuid(guid);
        // return document description
        return description;
    }
        
    public static String getStringFromStream(InputStream inputStream) throws IOException {        
        inputStream.reset();
        inputStream.skip(0);
        
        byte[] bytes = IOUtils.toByteArray(inputStream);
        // encode ByteArray into String
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public PageDataDescriptionEntity getDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        String password = "";
        try {
            // get/set parameters
            String documentGuid = loadDocumentPageRequest.getGuid();
            int pageNumber = loadDocumentPageRequest.getPage();
            password = loadDocumentPageRequest.getPassword();
            PageDataDescriptionEntity loadedPage = new PageDataDescriptionEntity();

            // get page image
            byte[] bytes;

            final Annotator annotator = new Annotator(documentGuid, getLoadOptions(password));
            try {
                final OutputStream renderPage = renderPageToMemoryStream(pageNumber, documentGuid, password);
                
                ByteArrayOutputStream bufferRenderPage = (ByteArrayOutputStream) renderPage;
                byte[] bytesRenderPage = bufferRenderPage.toByteArray();
                InputStream streamRenderPage = new ByteArrayInputStream(bytesRenderPage);

                try {
                    bytes = IOUtils.toByteArray(streamRenderPage);
                } finally {
                    if (streamRenderPage != null) {
                        streamRenderPage.close();
                    }
                }

                IDocumentInfo info = annotator.getDocument().getDocumentInfo();
                List<AnnotationBase> annotations = annotator.get();

                if (annotations != null && annotations.size() > 0) {
                    loadedPage.setAnnotations(AnnotationMapper.mapForPage(annotations, pageNumber, info.getPagesInfo().get(pageNumber - 1)));
                }

                String encodedImage = Base64.getEncoder().encodeToString(bytes);
                loadedPage.setData(encodedImage);

                loadedPage.setHeight(info.getPagesInfo().get(pageNumber - 1).getHeight());
                loadedPage.setWidth(info.getPagesInfo().get(pageNumber - 1).getWidth());
                loadedPage.setNumber(pageNumber);
            } finally {
                if (annotator != null) {
                    annotator.dispose();
                }
            }

            // return loaded page object
            return loadedPage;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage());
        }
    }
    
    private static OutputStream renderPageToMemoryStream(int pageNumberToRender, String documentGuid, String password) {
        try {
            OutputStream result = new ByteArrayOutputStream(); // MemoryStream => OutputStream
            InputStream inputStream = new FileInputStream(documentGuid); //final FileStream outputStream = File.openRead(documentGuid);
            try {
                final Annotator annotator = new Annotator(inputStream, getLoadOptions(password));
                try {
                    PreviewOptions previewOptions = new PreviewOptions( //PreviewOptions previewOptions = new PreviewOptions((pageNumber) =  > result);
                        new CreatePageStream() {
                            @Override
                            public OutputStream invoke(int pageNumber) {
                                return result;
                            }
                        }
                    );
                    previewOptions.setPreviewFormat(PreviewFormats.PNG);
                    previewOptions.setPageNumbers(new int[]{pageNumberToRender});
                    previewOptions.setRenderComments(false);

                    annotator.getDocument().generatePreview(previewOptions);
                } finally {
                    if (annotator != null) {
                        annotator.dispose();
                    }
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return result;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage());
	}
    }  

    private static LoadOptions getLoadOptions(String password) {
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);
        return loadOptions;
    }

    public InputStream annotateDocument(String documentGuid, String documentType, List<AnnotationBase> annotations) throws FileNotFoundException {
        Annotator annotator = new Annotator(documentGuid);
        
        SaveOptions saveOptions = new SaveOptions();
        saveOptions.setAnnotationTypes(AnnotationType.None);
          
        annotator.save(documentGuid, saveOptions);
        
        if (annotations.size() > 0) {
            annotator.add(annotations);
            annotator.save(documentGuid, new SaveOptions());
        }
        
        return new FileInputStream(documentGuid);
    }
    
    @Override
    public AnnotatedDocumentEntity annotate(AnnotationPostedDataEntity annotateDocumentRequest) {
        AnnotatedDocumentEntity annotatedDocument = new AnnotatedDocumentEntity();
        try {
            // get/set parameters
            String documentGuid = annotateDocumentRequest.getGuid();
            String password = annotateDocumentRequest.getPassword();
            
            //String documentType1 = DocumentTypesConverter.checkedDocumentType(documentGuid, annotateDocumentRequest.getDocumentType());
            String documentType = SupportedImageFormats.contains(
                FilenameUtils.getExtension(annotateDocumentRequest.getGuid())
            ) ? "image" : annotateDocumentRequest.getDocumentType();
            
            String tempPath = getTempPath(documentGuid);

            AnnotationDataEntity[] annotationsData = annotateDocumentRequest.getAnnotationsData();
            // initiate list of annotations to add
            List<AnnotationBase> annotations = new ArrayList<>();

            final Annotator annotator = new Annotator(documentGuid, getLoadOptions(password));
            try {
                IDocumentInfo info = annotator.getDocument().getDocumentInfo();

                for (int i = 0; i < annotationsData.length; i++) {
                    AnnotationDataEntity annotationData = annotationsData[i];
                    PageInfo pageInfo = info.getPagesInfo().get(annotationsData[i].getPageNumber() - 1);
                    // add annotation, if current annotation type isn't supported by the current document type it will be ignored
                    try {
                        BaseAnnotator baseAnnotator = AnnotatorFactory.createAnnotator(annotationData, pageInfo);
                        if (baseAnnotator.isSupported(documentType)) {
                            annotations.add(baseAnnotator.getAnnotationBase(documentType));
                        }
                    } catch (java.lang.RuntimeException ex) {
                        throw new AnnotatorException(ex.getMessage(), ex);
                    }
                }
            } finally {
                if (annotator != null) {
                    annotator.dispose();
                }
            }

            // Add annotation to the document
            removeAnnotations(documentGuid, password);
            // check if annotations array contains at least one annotation to add
            if (annotations.size() != 0) {
                final Annotator annotator1 = new Annotator(documentGuid, getLoadOptions(password));
                try {
                    //foreach to while statements conversion
                    Iterator tmp0 = (annotations).iterator();

                    while (tmp0.hasNext()) {
                        AnnotationBase annotation = (AnnotationBase) tmp0.next();
                        annotator1.add(annotation);
                    }

                    annotator1.save(tempPath);
                } finally {
                    if (annotator1 != null) {
                        annotator1.dispose();
                    }
                }

                try (OutputStream fileStream = new FileOutputStream(documentGuid)) {
                    InputStream inputStream1 = new FileInputStream(tempPath);
                    IOUtils.copyLarge(inputStream1, fileStream);
                }
            }

            annotatedDocument = new AnnotatedDocumentEntity();
            annotatedDocument.setGuid(documentGuid);
            if (annotateDocumentRequest.getPrint()) {
                annotatedDocument.setPages(getAnnotatedPagesForPrint(password, documentGuid));
                Files.move(Paths.get(documentGuid), Paths.get(annotateDocumentRequest.getGuid()));
            }
        } catch (Exception ex) {
            // set exception message
            throw new TotalGroupDocsException(ex.getMessage());
        }

        return annotatedDocument;
        
    }
    
    private List<PageDataDescriptionEntity> getAnnotatedPagesForPrint(String password, String documentGuid) {
        AnnotatedDocumentEntity description = new AnnotatedDocumentEntity();
        try {
            InputStream outputStream = new FileInputStream(documentGuid);
            try {
                final Annotator annotator = new Annotator(outputStream, getLoadOptions(password));
                try {
                    IDocumentInfo info = annotator.getDocument().getDocumentInfo();
                    List<String> pagesContent = getAllPagesContent(password, documentGuid, info);

                    for (int i = 0; i < info.getPageCount(); i++) {
                        PageDataDescriptionEntity page = new PageDataDescriptionEntity();

                        if (pagesContent.size() > 0) {
                            page.setData(pagesContent.get(i));
                        }

                        description.getPages().add(page);
                    }
                } finally {
                    if (annotator != null) {
                        annotator.dispose();
                    }
                }
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }

            return description.getPages();
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }
    
    private static String getTempPath(String documentGuid) {
        File fileName = new File(documentGuid);
        return fileName.getParentFile().getPath() + "//tmp_" + fileName.getName();
    }
    
    public static void removeAnnotations(String documentGuid, String password) {
        String tempPath = getTempPath(documentGuid);

        try {
            final InputStream inputStream = new FileInputStream(documentGuid);
            //final Stream inputStream = File.open(documentGuid, FileMode.Open, FileAccess.ReadWrite, FileShare.ReadWrite);
            try {
                final Annotator annotator = new Annotator(inputStream, getLoadOptions(password));
                try {
                    SaveOptions tmp0 = new SaveOptions();
                    tmp0.setAnnotationTypes(AnnotationType.None);
                    annotator.save(tempPath, tmp0);
                } finally {
                    if (annotator != null) {
                        annotator.dispose();
                    }
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            
            
            try (PrintWriter writer = new PrintWriter(documentGuid)) {                
                writer.print("");   
            }
            
            try (OutputStream fileStream = new FileOutputStream(documentGuid)) {
                InputStream inputStream1 = new FileInputStream(tempPath);
                IOUtils.copyLarge(inputStream1, fileStream);
            }
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }
    
    private String getText1(String tempPath) {
        String content = "";
        try {
            InputStream is = new FileInputStream(tempPath);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while(line != null){
               sb.append(line).append("\n");
               line = buf.readLine();
            }
            content = sb.toString();
        } catch(Throwable ex) {
            ex.getMessage();
        }
        return content;
    }
    
    private List<String> getAllPagesContent(String password, String documentGuid, IDocumentInfo pages) {
        List<String> allPages = new ArrayList<>();

            for (int i = 0; i < pages.getPageCount(); i++) {
                byte[] bytes;
                try (OutputStream memoryStream = renderPageToMemoryStream(i + 1, documentGuid, password)) {
                    ByteArrayOutputStream bos = (ByteArrayOutputStream) memoryStream;
                    bytes = bos.toByteArray(); //memoryStream.ToArray();
                } catch (IOException ex) {
                    throw new TotalGroupDocsException(ex.getMessage(), ex);
                }

                String encodedImage = new String(Base64.getEncoder().encode(bytes)); //Convert.ToBase64String(bytes);
                allPages.add(encodedImage);
            }

        return allPages;
    }
        
//------------------------------------------
    public List<AnnotationBase> getAnnotationInfos(AnnotationPostedDataEntity annotateDocumentRequest, String documentType) {
        try {
            AnnotationDataEntity[] annotationsData = annotateDocumentRequest.getAnnotationsData();
            // get document info - required to get document page height and calculate annotation top position

            List<AnnotationBase> annotations = new ArrayList<>();
            for (AnnotationDataEntity annotationData : annotationsData) {
                // create annotator
                // add annotation, if current annotation type isn't supported by the current document type it will be ignored              
                PageDataDescriptionEntity pageData = annotationPageDescriptionEntityList.get(annotationData.getPageNumber() - 1);
                
                PageInfo pageInfo = new PageInfo(); 
                pageInfo.setHeight((int) pageData.getHeight());
                //pageInfo.setPageNumber(pageData.getNumber());
                pageInfo.setWidth((int) pageData.getWidth());
                
                try {
                    annotations.add(AnnotatorFactory.createAnnotator(annotationData, pageInfo).getAnnotationBase(documentType));
                } catch (Throwable ex) {
                    throw new TotalGroupDocsException(ex.getMessage(), ex);
                }
            }
            return annotations;
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    @Override
    public InputStream annotateByStream(AnnotationPostedDataEntity annotateDocumentRequest) {
        String documentGuid = annotateDocumentRequest.getGuid();
        String documentType = DocumentTypesConverter.checkedDocumentType(documentGuid, annotateDocumentRequest.getDocumentType());
        List<AnnotationBase> annotations = getAnnotationInfos(annotateDocumentRequest, documentType);
        try {
            return annotateDocument(documentGuid, documentType, annotations);
        } catch (FileNotFoundException ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }
}