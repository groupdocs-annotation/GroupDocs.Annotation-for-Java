package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;

import java.text.ParseException;

public abstract class AbstractSvgAnnotator extends Annotator {

    public AbstractSvgAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        AnnotationInfo annotationInfo = super.initAnnotationInfo();
        // set draw annotation properties
        annotationInfo.setSvgPath(buildSvgPath());
        return annotationInfo;
    }

    /**
     * Use this method for fixing box coordinates if needed
     *
     * @param annotationInfo
     */
    protected void fixBox(AnnotationInfo annotationInfo) {
        double topPosition = pageData.getHeight() - annotationData.getTop();
        annotationInfo.getBox().setY((float) topPosition);
    }

    /**
     * Calculate svg position
     *
     * @return
     */
    protected String buildSvgPath() {
        // we use such calculation since the GroupDocs.Annotation library takes text line position from the bottom of the page
        double topPosition = pageData.getHeight() - annotationData.getTop();
        // calculation of the X-shift
        double topRightX = annotationData.getLeft() + annotationData.getWidth();
        // calculation of the Y-shift
        double bottomRightY = topPosition - annotationData.getHeight();
        return getSvgString(topPosition, annotationData.getLeft(), topRightX, bottomRightY);
    }

    /**
     * Build svg string
     *
     * @param top    top position
     * @param left   left position
     * @param right  right position
     * @param bottom bottom position
     * @return
     */
    protected String getSvgString(double top, double left, double right, double bottom) {
        return new StringBuilder().
                append("[{\"x\":").append(left).
                append(",\"y\":").append(top).
                append("},{\"x\":").append(right).
                append(",\"y\":").append(top).
                append("},{\"x\":").append(left).
                append(",\"y\":").append(bottom).
                append("},{\"x\":").append(right).
                append(",\"y\":").append(bottom).
                append("}]").toString();
    }

    @Override
    protected Rectangle getBox() {
        return new Rectangle(annotationData.getLeft(), annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight());
    }

}
