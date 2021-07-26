package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.ReplacementAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.exception.TotalGroupDocsException;


public class TextReplacementAnnotator extends AbstractTextAnnotator {

    private ReplacementAnnotation replacementAnnotation;

    public TextReplacementAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        replacementAnnotation = new ReplacementAnnotation();
        replacementAnnotation.setPoints(getPoints(annotationData, pageInfo));
        replacementAnnotation.setTextToReplace(annotationData.getText());
    }

    @Override
    public AnnotationBase annotateWord() {
        replacementAnnotation = (ReplacementAnnotation) initAnnotationBase(replacementAnnotation);
        return replacementAnnotation;
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
        throw new TotalGroupDocsException(Message + annotationData.getType());
    }

    @Override
    public AnnotationBase annotateDiagram() {
        throw new TotalGroupDocsException(Message + annotationData.getType());
    }

    @Override
    protected int getType() {
        return AnnotationType.TextReplacement;
    }
}