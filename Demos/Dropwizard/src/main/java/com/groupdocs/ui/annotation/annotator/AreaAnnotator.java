package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;

public class AreaAnnotator extends BaseAnnotator {

    private AreaAnnotation areaAnnotation;

    public AreaAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        areaAnnotation = new AreaAnnotation();
        areaAnnotation.setBox(getBox());
    }

    @Override
    public AnnotationBase annotateWord() {
        areaAnnotation = (AreaAnnotation) initAnnotationBase(areaAnnotation);
        return areaAnnotation;
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
        return AnnotationType.AREA;
    }
}
