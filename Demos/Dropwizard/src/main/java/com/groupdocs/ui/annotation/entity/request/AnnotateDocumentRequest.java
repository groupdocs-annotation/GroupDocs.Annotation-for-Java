package com.groupdocs.ui.annotation.entity.request;

import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;

/**
 * AnnotateDocumentRequest
 *
 * @author Aspose Pty Ltd
 */
public class AnnotateDocumentRequest extends LoadDocumentRequest {
    /**
     * List of annotation data
     */
    private AnnotationDataEntity[] annotationsData;
    /**
     * Document type
     */
    private String documentType;

    /**
     * For print annotated file
     */
    private Boolean print;

    public AnnotationDataEntity[] getAnnotationsData() {
        return annotationsData;
    }

    public void setAnnotationsData(AnnotationDataEntity[] annotationsData) {
        this.annotationsData = annotationsData;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Boolean getPrint() {
        return print;
    }

    public void setPrint(Boolean print) {
        this.print = print;
    }
}
