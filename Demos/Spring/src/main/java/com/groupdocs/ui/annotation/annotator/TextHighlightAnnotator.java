package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.HighlightAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.exception.TotalGroupDocsException;


public class TextHighlightAnnotator extends AbstractTextAnnotator {

    private HighlightAnnotation highlightAnnotation;

    public TextHighlightAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        highlightAnnotation = new HighlightAnnotation();
        highlightAnnotation.setPoints(getPoints(annotationData, pageInfo));
    }

    @Override
    public AnnotationBase annotateWord() {
        highlightAnnotation = (HighlightAnnotation) initAnnotationBase(highlightAnnotation);
        return highlightAnnotation;
    }

    @Override
    public AnnotationBase annotatePdf() {
        return annotateWord();
    }

    @Override
    public AnnotationBase annotateCells() {
        return annotateWord();
    }

    @Override
    public AnnotationBase annotateSlides() {
        return annotateWord();
    }

    @Override
    public AnnotationBase annotateImage() {
        return annotateWord();
    }

    @Override
    public AnnotationBase annotateDiagram() {
        throw new TotalGroupDocsException(Message + annotationData.getType());
    }

    @Override
    protected int getType() {
        return AnnotationType.TextHighlight;
    }
}