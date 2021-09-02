package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.PointAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;


public class PointAnnotator extends BaseAnnotator {

    private PointAnnotation pointAnnotation;

    public PointAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        pointAnnotation = new PointAnnotation();
        pointAnnotation.setBox(getBox());
    }

    @Override
    public AnnotationBase annotateWord() {
        pointAnnotation = (PointAnnotation) super.initAnnotationBase(pointAnnotation);
        return pointAnnotation;
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
        return annotateWord();
    }

    @Override
    protected int getType() {
        return AnnotationType.Point;
    }
}
