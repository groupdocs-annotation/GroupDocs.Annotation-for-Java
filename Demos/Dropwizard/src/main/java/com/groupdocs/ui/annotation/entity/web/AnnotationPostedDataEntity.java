/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupdocs.ui.annotation.entity.web;

import com.groupdocs.ui.annotation.entity.request.PostedDataEntity;

/**
 *
 * @author AlexT
 */
public class AnnotationPostedDataEntity extends PostedDataEntity {

    public final String getDocumentType() {
        return documentType;
    }

    public final void setDocumentType(String value) {
        documentType = value;
    }
    private String documentType;

    public final AnnotationDataEntity[] getAnnotationsData() {
        return annotationsData;
    }

    public final void setAnnotationsData(AnnotationDataEntity[] value) {
        annotationsData = value;
    }
    private AnnotationDataEntity[] annotationsData;

    public final boolean getPrint() {
        return print;
    }

    public final void setPrint(boolean value) {
        print = value;
    }
    private boolean print;
}
