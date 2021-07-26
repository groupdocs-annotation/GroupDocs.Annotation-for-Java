package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.StrikeoutAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.exception.TotalGroupDocsException;

public class TextStrikeoutAnnotator extends AbstractTextAnnotator {

    private StrikeoutAnnotation strikeoutAnnotation;

    public TextStrikeoutAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        strikeoutAnnotation = new StrikeoutAnnotation();
        strikeoutAnnotation.setPoints(getPoints(annotationData, pageInfo));
    }

    @Override
    public AnnotationBase annotateWord() {
        strikeoutAnnotation = (StrikeoutAnnotation) initAnnotationBase(strikeoutAnnotation);
        return strikeoutAnnotation;
    }

    @Override
    public AnnotationBase annotatePdf() {
        strikeoutAnnotation = (StrikeoutAnnotation) initAnnotationBase(strikeoutAnnotation);
        this.strikeoutAnnotation.setFontColor(0);
        return strikeoutAnnotation;
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
        return AnnotationType.TextStrikeout;
    }
}