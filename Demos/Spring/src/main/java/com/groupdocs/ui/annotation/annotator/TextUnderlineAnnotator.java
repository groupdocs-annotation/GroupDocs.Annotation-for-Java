package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.UnderlineAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.exception.TotalGroupDocsException;


public class TextUnderlineAnnotator extends AbstractTextAnnotator {

    private UnderlineAnnotation underlineAnnotation;

    public TextUnderlineAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        underlineAnnotation = new UnderlineAnnotation();
        underlineAnnotation.setPoints(getPoints(annotationData, pageInfo));
    }

    @Override
    public AnnotationBase annotateWord() {
        underlineAnnotation = (UnderlineAnnotation) initAnnotationBase(underlineAnnotation);
        underlineAnnotation.setFontColor(1201033);
        return underlineAnnotation;
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
        underlineAnnotation = (UnderlineAnnotation) initAnnotationBase(underlineAnnotation);
        underlineAnnotation.setFontColor(0);
        return underlineAnnotation;
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
        return AnnotationType.TextUnderline;
    }
}