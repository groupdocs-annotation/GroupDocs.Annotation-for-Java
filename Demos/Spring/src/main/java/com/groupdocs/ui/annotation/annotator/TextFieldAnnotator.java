package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.TextFieldAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;


public class TextFieldAnnotator extends BaseAnnotator {

    private TextFieldAnnotation textFieldAnnotation;
    
    public TextFieldAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        textFieldAnnotation = new TextFieldAnnotation();
        textFieldAnnotation.setBox(getBox());
        
        textFieldAnnotation.setFontFamily(annotationData.getFont() != null ||  !"".equals(annotationData.getFont()) ? annotationData.getFont() : "Arial");
        textFieldAnnotation.setFontColor(annotationData.getFontColor());
        textFieldAnnotation.setFontSize(annotationData.getFontSize() == 0 ? 12 : annotationData.getFontSize());
        textFieldAnnotation.setText(annotationData.getText());
    }

    @Override
    public AnnotationBase annotateWord() {
        textFieldAnnotation = (TextFieldAnnotation) initAnnotationBase(textFieldAnnotation);
        return textFieldAnnotation;
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
        return AnnotationType.TextField;
    }
}