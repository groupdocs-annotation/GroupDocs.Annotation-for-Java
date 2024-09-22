package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.IDocumentInfo;
import com.groupdocs.examples.annotation.SampleFiles;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class GetFileInfoTests {

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