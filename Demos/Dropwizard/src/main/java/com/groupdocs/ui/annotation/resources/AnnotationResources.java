package com.groupdocs.ui.annotation.resources;

import com.groupdocs.ui.annotation.config.AnnotationConfigurationModel;
import com.groupdocs.ui.annotation.entity.web.AnnotatedDocumentEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationPostedDataEntity;
import com.groupdocs.ui.annotation.entity.web.PageDataDescriptionEntity;
import com.groupdocs.ui.annotation.service.AnnotationService;
import com.groupdocs.ui.annotation.service.AnnotationServiceImpl;
import com.groupdocs.ui.annotation.views.Annotation;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.entity.web.UploadedDocumentEntity;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.common.resources.Resources;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.*;
import java.net.UnknownHostException;
import java.util.*;
import static javax.ws.rs.core.MediaType.*;


/**
 * AnnotationResources
 *
 * @author Aspose Pty Ltd
 */
@Path(value = "/annotation")
public class AnnotationResources extends Resources {
    private static final Logger logger = LoggerFactory.getLogger(AnnotationResources.class);
    
    private AnnotationService annotationService;

    /**
     * Constructor
     *
     * @param globalConfiguration global configuration object
     * @throws UnknownHostException
     */
    public AnnotationResources(GlobalConfiguration globalConfiguration) throws UnknownHostException {
        super(globalConfiguration);

        annotationService = new AnnotationServiceImpl(globalConfiguration);
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
        return AnnotationConfigurationModel.createAnnotationConfiguration(annotationService.getAnnotationConfiguration(), globalConfiguration.getCommon());
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
        return annotationService.getFileList(fileTreeRequest);
    }
    
    /**
     * Get document description
     *
     * @param loadDocumentRequest
     * @return document description
     */
    @POST
    @Path(value = "/loadDocumentDescription")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public AnnotatedDocumentEntity loadDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        return annotationService.getDocumentDescription(loadDocumentRequest);
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
    public PageDataDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        return annotationService.getDocumentPage(loadDocumentPageRequest);
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
    public AnnotatedDocumentEntity annotate(AnnotationPostedDataEntity annotateDocumentRequest) {
        return annotationService.annotate(annotateDocumentRequest);
    }
    
    
    /**
     * Download document
     *
     * @param documentGuid path to document parameter
     * @param response
     */
    @GET
    @Path(value = "/downloadAnnotated")
    @Produces(APPLICATION_OCTET_STREAM)
    public void downloadAnnotated(@QueryParam("path") String documentGuid,
                                 @Context HttpServletResponse response) {
        // download the file
        downloadFile(response, documentGuid);
    }
}