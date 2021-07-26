package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.DistanceAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.CommentsEntity;

public class DistanceAnnotator extends BaseAnnotator {

    private DistanceAnnotation distanceAnnotation;

    public DistanceAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        distanceAnnotation = new DistanceAnnotation();
        distanceAnnotation.setBox(getBox());
    }

    @Override
    public AnnotationBase annotateWord() {
        distanceAnnotation = (DistanceAnnotation) initAnnotationBaseDistanceAnnotator(distanceAnnotation);
        return distanceAnnotation;
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

    protected final AnnotationBase initAnnotationBaseDistanceAnnotator(AnnotationBase annotationBase) {
        distanceAnnotation = (DistanceAnnotation) super.initAnnotationBase(annotationBase);
        String tmp0 = annotationData.getText();
        if (tmp0 == null) {
            tmp0 = "";
        }
        // add replies
        String text = tmp0;
        CommentsEntity[] comments = annotationData.getComments();
        if (comments != null && comments.length != 0) {
            Reply reply = distanceAnnotation.getReplies().get(0);
            if (reply != null) {
                reply.setComment(String.format("{0} {1}", text, reply.getComment()));
            }
        }

        return distanceAnnotation;
    }

    @Override
    protected int getType() {
        return AnnotationType.Distance;
    }

    @Override
    protected Rectangle getBox() {
        String svgPath = annotationData.getSvgPath();
        
        String startPoint = svgPath.replaceAll("[a-zA-Z]+", "").split(" ")[0];
        String endPoint = svgPath.replaceAll("[a-zA-Z]+", "").split(" ")[1];
        String[] start = startPoint.split(",");
        float startX = Float.parseFloat(start.length > 0 ? start[0] : "0");
        float startY = Float.parseFloat(start.length > 1 ? start[1] : "0");
        String[] end = endPoint.split(",");
        float endX = Float.parseFloat(end.length > 0 ? end[0] : "0") - startX;
        float endY = Float.parseFloat(end.length > 1 ? end[1] : "0") - startY;
        return new Rectangle(startX, startY, endX, endY);      
    }
}
