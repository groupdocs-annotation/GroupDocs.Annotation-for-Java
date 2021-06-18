package com.groupdocs.ui.annotation.entity.web;

import java.util.List;

/**
 * AnnotatedDocumentEntity
 *
 * @author Aspose Pty Ltd
 */
public class AnnotatedDocumentEntity {
    /**
     * Document Guid
     */
    private String guid;
    /**
     * List of supported types of annotations
     */
    public String[] supportedAnnotations;
    /**
     * list of pages
     */
    private List<AnnotationPageDescriptionEntity> pages;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String[] getSupportedAnnotations() {
        return supportedAnnotations;
    }

    public void setSupportedAnnotations(String[] supportedAnnotations) {
        this.supportedAnnotations = supportedAnnotations;
    }

    public List<AnnotationPageDescriptionEntity> getPages() {
        return pages;
    }

    public void setPages(List<AnnotationPageDescriptionEntity> pages) {
        this.pages = pages;
    }
}
