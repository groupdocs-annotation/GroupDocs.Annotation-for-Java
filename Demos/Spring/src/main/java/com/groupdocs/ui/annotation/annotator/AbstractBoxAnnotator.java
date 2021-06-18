package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Point;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;

import java.text.ParseException;

public abstract class AbstractBoxAnnotator extends Annotator {

    public AbstractBoxAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        AnnotationInfo annotationInfo = super.initAnnotationInfo();
        // set draw annotation properties
        Rectangle box = annotationInfo.getBox();
        StringBuilder builder = new StringBuilder().
                append("M").append(box.getX()).
                append(",").append(box.getY()).
                append("L").append(box.getWidth()).
                append(",").append(box.getHeight());
        annotationInfo.setSvgPath(builder.toString());
        // set annotation position
        annotationInfo.setAnnotationPosition(new Point(annotationData.getLeft(), annotationData.getTop()));
        return annotationInfo;
    }

    @Override
    protected Rectangle getBox() {
        String svgPath = annotationData.getSvgPath();
        String startPoint = svgPath.replaceAll("[a-zA-Z]+", "").split(" ")[0];
        String endPoint = svgPath.replaceAll("[a-zA-Z]+", "").split(" ")[1];
        String[] start = startPoint.split(",");
        double startX = Double.parseDouble(start.length > 0 ? start[0] : "0");
        double startY = Double.parseDouble(start.length > 1 ? start[1] : "0");
        String[] end = endPoint.split(",");
        double endX = Double.parseDouble(end.length > 0 ? end[0] : "0") - startX;
        double endY = Double.parseDouble(end.length > 1 ? end[1] : "0") - startY;
        return new Rectangle(startX, startY, endX, endY);
    }
}
