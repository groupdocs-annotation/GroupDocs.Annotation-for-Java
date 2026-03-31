package com.groupdocs.ui.annotation.service;

import com.groupdocs.ui.annotation.config.AnnotationConfiguration;
import com.groupdocs.ui.annotation.entity.web.AnnotatedDocumentEntity;
import com.groupdocs.ui.annotation.entity.web.AnnotationPostedDataEntity;
import com.groupdocs.ui.annotation.entity.web.PageDataDescriptionEntity;
import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.model.request.FileTreeRequest;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import java.io.InputStream;
import java.util.List;

/**
 * Service for annotating documents
 */
public interface AnnotationService {
    /**
     * Get global configuration
     *
     * @return global configuration
     */
    GlobalConfiguration getGlobalConfiguration();

    /**
     * Get annotation configuration
     *
     * @return annotation configuration
     */
    AnnotationConfiguration getAnnotationConfiguration();

    /**
     * Get list of files and folders
     *
     * @param fileTreeRequest request object with path for loading list of files
     * @return list of files and folders
     */
    List<FileDescriptionEntity> getFileList(FileTreeRequest fileTreeRequest);

    /**
     * Get document information
     *
     * @param loadDocumentRequest request object with document guid
     * @return document with list of pages
     */
    AnnotatedDocumentEntity getDocumentDescription(LoadDocumentRequest loadDocumentRequest);

    /**
     * Load document page
     *
     * @param loadDocumentPageRequest request object with document guid and page number
     * @return document page data
     */
    PageDataDescriptionEntity getDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest);

    /**
     * Annotate document
     *
     * @param annotateDocumentRequest request object with document guid and annotations data
     * @return annotated document
     */
    AnnotatedDocumentEntity annotate(AnnotationPostedDataEntity annotateDocumentRequest);

    /**
     * Annotate document by streams
     *
     * @param annotateDocumentRequest request object with document guid and annotations data
     * @return stream of annotated document
     */
    InputStream annotateByStream(AnnotationPostedDataEntity annotateDocumentRequest);

    /**
     * Get raw page image bytes (PNG) for streaming endpoint
     *
     * @param guid document path
     * @param pageNumber page number (1-based)
     * @param password document password (nullable)
     * @return PNG image bytes
     */
    byte[] getPageImageBytes(String guid, int pageNumber, String password);
}
