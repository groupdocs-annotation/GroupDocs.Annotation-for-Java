/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupdocs.ui.annotation.entity.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author AlexT
 */
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
