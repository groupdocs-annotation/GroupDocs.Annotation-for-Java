package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.WatermarkAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.exception.TotalGroupDocsException;

public class WatermarkAnnotator extends BaseAnnotator {

    private WatermarkAnnotation watermarkAnnotation;

    public WatermarkAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        watermarkAnnotation = new WatermarkAnnotation();
        watermarkAnnotation.setBox(getBox());
        watermarkAnnotation.setFontFamily(annotationData.getFont() != null ||  !"".equals(annotationData.getFont()) ? annotationData.getFont() : "Arial");
        watermarkAnnotation.setFontColor(annotationData.getFontColor());
        watermarkAnnotation.setFontSize(annotationData.getFontSize() == 0 ? 12 : annotationData.getFontSize());
        watermarkAnnotation.setText(annotationData.getText());
    }

    @Override
    public AnnotationBase annotateWord() {
        watermarkAnnotation = (WatermarkAnnotation) initAnnotationBase(watermarkAnnotation);
        return watermarkAnnotation;
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
        throw new TotalGroupDocsException(Message + annotationData.getType());
    }

    @Override
    protected int getType() {
        return AnnotationType.WATERMARK;
    }
}