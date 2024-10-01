package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.IDocumentInfo;
import com.groupdocs.examples.annotation.SampleFiles;
import com.groupdocs.examples.annotation.TestsSetUp;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetFileInfoTests extends TestsSetUp {

    @Test
    public void testRunPdf() {
        final IDocumentInfo documentInfo = GetFileInfo.run(SampleFiles.INPUT_PDF);
        assertThat(documentInfo).isNotNull();
    }

    @Test
    public void testRunDoc() {
        final IDocumentInfo documentInfo = GetFileInfo.run(SampleFiles.INPUT_DOC);
        assertThat(documentInfo).isNotNull();
    }

    @Test
    public void testRunCells() {
        final IDocumentInfo documentInfo = GetFileInfo.run(SampleFiles.INPUT_CELL);
        assertThat(documentInfo).isNotNull();
    }
}