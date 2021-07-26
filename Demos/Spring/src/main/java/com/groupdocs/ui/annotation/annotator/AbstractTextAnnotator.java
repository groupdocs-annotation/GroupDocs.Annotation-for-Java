package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTextAnnotator extends BaseAnnotator {

    protected AbstractTextAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);
    }

    protected static java.util.List<Point> getPoints(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        List<Point> tmp0 = new ArrayList<>();
        tmp0.add(new Point(annotationData.getLeft(), pageInfo.getHeight() - annotationData.getTop()));
        tmp0.add(new Point(annotationData.getLeft()+ annotationData.getWidth(), pageInfo.getHeight() - annotationData.getTop()));
        tmp0.add(new Point(annotationData.getLeft(), pageInfo.getHeight() - annotationData.getTop()- annotationData.getHeight()));
        tmp0.add(new Point(annotationData.getLeft()+ annotationData.getWidth(), pageInfo.getHeight() - annotationData.getTop()- annotationData.getHeight()));
        return tmp0;
    }
}