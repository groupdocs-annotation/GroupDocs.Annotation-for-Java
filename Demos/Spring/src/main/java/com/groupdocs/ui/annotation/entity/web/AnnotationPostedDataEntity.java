package com.groupdocs.ui.annotation.entity.web;

import com.groupdocs.ui.annotation.entity.request.PostedDataEntity;


/**
 * <p>
 * SignaturePostedDataEntity
 * </p>
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