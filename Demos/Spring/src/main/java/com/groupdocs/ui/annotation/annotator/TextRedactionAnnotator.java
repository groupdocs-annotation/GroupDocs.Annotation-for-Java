package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.TextRedactionAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.exception.TotalGroupDocsException;

public class TextRedactionAnnotator extends TextHighlightAnnotator {

    private TextRedactionAnnotation textRedactionAnnotation;

    public TextRedactionAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        textRedactionAnnotation = new TextRedactionAnnotation();
        textRedactionAnnotation.setPoints(getPoints(annotationData, pageInfo));
    }

    @Override
    public AnnotationBase annotateCells() {
        return annotatePdf();
    }

    @Override
    public AnnotationBase annotateSlides() {
        return annotatePdf();
    }

    @Override
    public AnnotationBase annotateImage() {
        throw new TotalGroupDocsException(Message + annotationData.getType());
    }

    @Override
    public AnnotationBase annotateDiagram() {
        throw new TotalGroupDocsException(Message + annotationData.getType());
    }

    @Override
    public AnnotationBase annotatePdf() {
        textRedactionAnnotation = (TextRedactionAnnotation) initAnnotationBase(textRedactionAnnotation);
        return textRedactionAnnotation;
    }

    @Override
    protected int getType() {
        return AnnotationType.TextRedaction;
    }
}