package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.examples.annotation.SampleFiles;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtractAnnotationsFromDocumentTests {

    @Test
    public void testRunPdf() {
        final List<AnnotationBase> annotations = ExtractAnnotationsFromDocument.run(SampleFiles.INPUT_PDF);
        assertThat(annotations).isNotNull().hasSize(0);
    }

    @Test
    public void testRunDoc() {
        final List<AnnotationBase> annotations = ExtractAnnotationsFromDocument.run(SampleFiles.INPUT_DOC);
        assertThat(annotations).isNotNull().hasSize(0);
    }

    @Test
    public void testRunCells() {
        final List<AnnotationBase> annotations = ExtractAnnotationsFromDocument.run(SampleFiles.INPUT_CELL);
        assertThat(annotations).isNotNull().hasSize(0);
    }
}