package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;

public abstract class AbstractTextAnnotator extends Annotator {

    public AbstractTextAnnotator(AnnotationDataEntity annotationData, PageData pageData) {
        super(annotationData, pageData);
    }

    @Override
    protected AnnotationInfo initAnnotationInfo() throws ParseException {
        AnnotationInfo annotationInfo = super.initAnnotationInfo();
        annotationInfo.setFieldText(annotationData.getText());
        annotationInfo.setFontFamily(StringUtils.capitalize(annotationData.getFont()));
        annotationInfo.setFontSize(annotationData.getFontSize());
        annotationInfo.setFontColor(annotationData.getFontColor());
        return annotationInfo;
    }

    @Override
    protected Rectangle getBox() {
        return new Rectangle(annotationData.getLeft(), annotationData.getTop(), annotationData.getWidth(), annotationData.getHeight());
    }
}
