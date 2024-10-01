package com.groupdocs.examples.annotation.advanced_usage;

import com.groupdocs.examples.annotation.SampleFiles;
import com.groupdocs.examples.annotation.TestsSetUp;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateDocumentPagesPreviewTests extends TestsSetUp {

    @Test
    public void testRunPdf() {
        final List<Path> resultPaths = GenerateDocumentPagesPreview.run(SampleFiles.INPUT_PDF);
        assertThat(resultPaths).hasSize(2);
        resultPaths.forEach(path -> assertThat(path).exists());
    }

    @Test
    public void testRunDoc() {
        final List<Path> resultPaths = GenerateDocumentPagesPreview.run(SampleFiles.INPUT_DOC);
        assertThat(resultPaths).hasSize(2);
        resultPaths.forEach(path -> assertThat(path).exists());
    }

    @Test
    public void testRunCells() {
        final List<Path> resultPaths = GenerateDocumentPagesPreview.run(SampleFiles.INPUT_CELL);
        assertThat(resultPaths).hasSize(2);
        resultPaths.forEach(path -> assertThat(path).exists());
    }
}