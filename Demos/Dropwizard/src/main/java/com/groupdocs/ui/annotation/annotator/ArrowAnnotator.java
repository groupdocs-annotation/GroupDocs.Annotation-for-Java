package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.ArrowAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.annotation.entity.web.CommentsEntity;

public class ArrowAnnotator extends BaseAnnotator {

    private boolean withGuid = false;
    private ArrowAnnotation arrowAnnotation;

    public ArrowAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        this.arrowAnnotation = new ArrowAnnotation();
        this.arrowAnnotation.setBox(getBox());
    }

    @Override
    public AnnotationBase annotateWord() {
        withGuid = false;
        arrowAnnotation = (ArrowAnnotation) initAnnotationBase(arrowAnnotation);
        return arrowAnnotation;
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
        withGuid = true;
        arrowAnnotation = (ArrowAnnotation) initAnnotationBase(arrowAnnotation);
        return arrowAnnotation;
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
    protected Reply getAnnotationReplyInfo(CommentsEntity comment) {
        Reply annotationReplyInfo = super.getAnnotationReplyInfo(comment);
        if (withGuid) {
            annotationReplyInfo.setParentReply(new Reply());
            annotationReplyInfo.getParentReply().setId(annotationData.getId());
        }
        return annotationReplyInfo;
    }

    @Override
    protected int getType() {
        return AnnotationType.Arrow;
    }

    @Override
    protected Rectangle getBox() {        
        String svgPath = annotationData.getSvgPath();
        
        String startPoint = svgPath.replace("[a-zA-Z]+", "").split(" ")[0];
        String endPoint = svgPath.replace("[a-zA-Z]+", "").split(" ")[1];
        
        String[] start = startPoint.split(",");
        float startX = Float.parseFloat(start.length > 0 ? start[0].replace("M", "").replace(",", ".") : "0");
        float startY = Float.parseFloat(start.length > 0 ? start[1].replace("M", "").replace(",", ".") : "0");
        
        String[] end = endPoint.split(",");
        float endX = Float.parseFloat(end.length > 0 ? end[0].replace("L", "").replace(",", ".") : "0") - startX;
        float endY = Float.parseFloat(end.length > 1 ? end[1].replace("L", "").replace(",", ".") : "0") - startY;
        
        return new Rectangle(startX, startY, endX, endY);
    }
}