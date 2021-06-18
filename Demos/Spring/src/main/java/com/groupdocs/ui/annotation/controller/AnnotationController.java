package com.groupdocs.ui.annotation.controller;

import com.groupdocs.ui.annotation.config.AnnotationConfiguration;
import com.groupdocs.ui.annotation.entity.request.AnnotateDocumentRequest;
import com.groupdocs.ui.annotation.entity.web.AnnotatedDocumentEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationPageDescriptionEntity;
import com.groupdocs.ui.annotation.service.AnnotationService;
import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.request.FileTreeRequest;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import com.groupdocs.ui.model.response.UploadedDocumentEntity;
import com.groupdocs.ui.util.Utils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nullable;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.groupdocs.ui.util.Utils.setLocalPort;
import static com.groupdocs.ui.util.Utils.uploadFile;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

/**
 * AnnotationController
 *
 * @author Aspose Pty Ltd
 */
@Controller
@RequestMapping(value = "/annotation")
public class AnnotationController {
    private static final Logger logger = LoggerFactory.getLogger(AnnotationController.class);

    @Autowired
    private AnnotationService annotationService;

    /**
     * Get annotation page
     *
     * @param request
     * @param model   model data for template
     * @return template name
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getView(HttpServletRequest request, Map<String, Object> model) {
        GlobalConfiguration globalConfiguration = annotationService.getGlobalConfiguration();

        setLocalPort(request, globalConfiguration.getServer());

        model.put("globalConfiguration", globalConfiguration);

        AnnotationConfiguration annotationConfiguration = annotationService.getAnnotationConfiguration();
        logger.debug("annotation config: {}", annotationConfiguration);
        model.put("annotationConfiguration", annotationConfiguration);
        return "annotation";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loadConfig", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public AnnotationConfiguration loadConfig() {
        return annotationService.getAnnotationConfiguration();
    }

    /**
     * Get files and directories
     *
     * @param fileTreeRequest request's object with specified path
     * @return files and directories list
     */
    @RequestMapping(value = "/loadFileTree", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<FileDescriptionEntity> loadFileTree(@RequestBody FileTreeRequest fileTreeRequest) {
        return annotationService.getFileList(fileTreeRequest);
    }

    /**
     * Get document description
     *
     * @return document description
     */
    @RequestMapping(value = "/loadDocumentDescription", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public AnnotatedDocumentEntity loadDocumentDescription(@RequestBody LoadDocumentRequest loadDocumentRequest) {
        return annotationService.getDocumentDescription(loadDocumentRequest);
    }

    /**
     * Get document page
     *
     * @return document page
     */
    @RequestMapping(value = "/loadDocumentPage", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public AnnotationPageDescriptionEntity loadDocumentPage(@RequestBody LoadDocumentPageRequest loadDocumentPageRequest) {
        return annotationService.getDocumentPage(loadDocumentPageRequest);
    }

    /**
     * Download document
     *
     * @param documentGuid path to document parameter
     * @param response     http response
     */
    @RequestMapping(value = "/downloadDocument", method = RequestMethod.GET)
    public void downloadDocument(@RequestParam("path") String documentGuid,
                                 HttpServletResponse response) {
        // get document path
        String fileName = FilenameUtils.getName(documentGuid);

        // set response content info
        Utils.addFileDownloadHeaders(response, fileName, null);

        long length;
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(documentGuid));
             ServletOutputStream outputStream = response.getOutputStream()) {
            // download the document
            length = IOUtils.copyLarge(inputStream, outputStream);
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }

        Utils.addFileDownloadLengthHeader(response, length);
    }

    /**
     * Upload document
     *
     * @param content file data
     * @param url     url for document
     * @param rewrite flag for rewriting file
     * @return uploaded document object (the object contains uploaded document guid)
     */
    @RequestMapping(value = "/uploadDocument", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE, consumes = MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public UploadedDocumentEntity uploadDocument(@Nullable @RequestParam("file") MultipartFile content,
                                                 @RequestParam(value = "url", required = false) String url,
                                                 @RequestParam("rewrite") Boolean rewrite) {
        // get documents storage path
        String documentStoragePath = annotationService.getAnnotationConfiguration().getFilesDirectory();
        // save the file
        String pathname = uploadFile(documentStoragePath, content, url, rewrite);
        // create response data
        UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
        uploadedDocument.setGuid(pathname);
        return uploadedDocument;
    }

    /**
     * Annotate document with annotations and download result without saving
     *
     * @return annotated document info
     */
    @RequestMapping(method = RequestMethod.POST, value = "/downloadAnnotated", consumes = APPLICATION_JSON_VALUE)
    public void downloadAnnotated(@RequestBody AnnotateDocumentRequest annotateDocumentRequest, HttpServletResponse response) {
        AnnotationDataEntity[] annotationsData = annotateDocumentRequest.getAnnotationsData();
        if (annotationsData == null || annotationsData.length == 0) {
            throw new IllegalArgumentException("Annotations data is empty");
        }

        // get document path
        String fileName = FilenameUtils.getName(annotateDocumentRequest.getGuid());
        // set response content info
        Utils.addFileDownloadHeaders(response, fileName, null);

        long length;
        try (InputStream inputStream = annotationService.annotateByStream(annotateDocumentRequest);
             ServletOutputStream outputStream = response.getOutputStream()) {
            // download the document
            length = IOUtils.copyLarge(inputStream, outputStream);
        } catch (Exception ex) {
            logger.error("Exception in downloading document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
        Utils.addFileDownloadLengthHeader(response, length);
    }

    /**
     * Annotate document
     *
     * @param annotateDocumentRequest
     * @return annotated document info
     */
    @RequestMapping(value = "/annotate", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public AnnotatedDocumentEntity annotate(@RequestBody AnnotateDocumentRequest annotateDocumentRequest) {
        return annotationService.annotate(annotateDocumentRequest);
    }

}