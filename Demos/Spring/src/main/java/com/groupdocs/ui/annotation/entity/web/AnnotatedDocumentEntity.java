package com.groupdocs.ui.annotation.entity.web;

import com.groupdocs.ui.model.response.PageDescriptionEntity;
import java.util.ArrayList;
import java.util.List;

public class AnnotatedDocumentEntity extends PageDescriptionEntity {

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
    private List<PageDataDescriptionEntity> pages = new ArrayList<>();

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

    public List<PageDataDescriptionEntity> getPages() {
        return pages;
    }

    public void setPages(List<PageDataDescriptionEntity> pages) {
        this.pages = pages;
    }
}
