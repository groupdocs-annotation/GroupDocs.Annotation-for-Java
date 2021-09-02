package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.User;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.PolylineAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.CommentsEntity;


public class PolylineAnnotator extends BaseAnnotator {

    private PolylineAnnotation polylineAnnotation;

    public PolylineAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        this.polylineAnnotation = new PolylineAnnotation();
        this.polylineAnnotation.setBox(getBox());
        this.polylineAnnotation.setPenColor(1201033);
        this.polylineAnnotation.setPenWidth((byte) 2);
        this.polylineAnnotation.setSvgPath(annotationData.getSvgPath());
    }

    @Override
    public AnnotationBase annotateWord() {
        polylineAnnotation = (PolylineAnnotation) initAnnotationBase(polylineAnnotation);
        return polylineAnnotation;
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
        polylineAnnotation = (PolylineAnnotation) initAnnotationBase(polylineAnnotation);
        fillCreatorName(polylineAnnotation, annotationData);
        return polylineAnnotation;
    }

    /**
     * <p>
     * Fill creator name field in annotation info
     * </p>
     *
     * @param polylineAnnotation AnnotationBase
     * @param annotationData
     */
    protected static void fillCreatorName(AnnotationBase polylineAnnotation, AnnotationDataEntity annotationData) {
        CommentsEntity[] comments = annotationData.getComments();
        if (comments != null && comments.length > 0 && comments[0] != null) {
            polylineAnnotation.setUser(new User());
            polylineAnnotation.getUser().setName(comments[0].getUserName());
        }
    }

    @Override
    public AnnotationBase annotateImage() {
        return annotateSlides();
    }

    @Override
    public AnnotationBase annotateDiagram() {
        return annotateSlides();
    }

    @Override
    protected int getType() {
        return AnnotationType.Polyline;
    }
}
