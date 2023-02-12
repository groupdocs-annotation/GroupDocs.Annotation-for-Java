package com.groupdocs.ui.annotation.annotator;

import com.groupdocs.annotation.models.PageInfo;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.models.annotationmodels.ResourcesRedactionAnnotation;
import com.groupdocs.annotation.options.export.AnnotationType;
import com.groupdocs.ui.annotation.entity.web.AnnotationDataEntity;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;


public class ResourceRedactionAnnotator extends BaseAnnotator {

    private ResourcesRedactionAnnotation resourcesRedactionAnnotation;

    public ResourceRedactionAnnotator(AnnotationDataEntity annotationData, PageInfo pageInfo) {
        super(annotationData, pageInfo);

        this.resourcesRedactionAnnotation = new ResourcesRedactionAnnotation();
        this.resourcesRedactionAnnotation.setBox(getBox());
    }

    @Override
    public AnnotationBase annotateWord() {
        resourcesRedactionAnnotation = (ResourcesRedactionAnnotation) initAnnotationBase(resourcesRedactionAnnotation);
        return resourcesRedactionAnnotation;
    }

    @Override
    public AnnotationBase annotatePdf() {
        return annotateWord();
    }

    @Override
    public AnnotationBase annotateCells() {
        throw new TotalGroupDocsException(Message + annotationData.getType());
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
        return AnnotationType.RESOURCES_REDACTION;
    }
}