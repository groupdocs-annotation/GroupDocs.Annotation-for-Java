package com.groupdocs.ui.annotation.entity.web;

import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;

public class AnnotationPageDescriptionEntity extends PageDescriptionEntity {

    /**
     * List of annotation data
     */
    private AnnotationDataEntity[] annotations;

    public AnnotationDataEntity[] getAnnotations() {
        return annotations;
    }

    public void setAnnotations(AnnotationDataEntity[] annotations) {
        this.annotations = annotations;
    }

}
