package com.groupdocs.ui.annotation.entity.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.model.response.PageDescriptionEntity;
import java.util.List;

public class PageDataDescriptionEntity extends PageDescriptionEntity {

    @JsonProperty
    private List<AnnotationDataEntity> annotations; // AnnotationDataEntity[] => List<AnnotationDataEntity>

    public final void setAnnotations(List<AnnotationDataEntity> annotations) {
        this.annotations = annotations;
    }

    public final List<AnnotationDataEntity> getAnnotations() {
        return annotations;
    }
}