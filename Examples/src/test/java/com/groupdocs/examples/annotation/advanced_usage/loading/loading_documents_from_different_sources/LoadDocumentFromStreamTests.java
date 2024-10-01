package com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.examples.annotation.SampleFiles;
import com.groupdocs.examples.annotation.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class LoadDocumentFromStreamTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path path = LoadDocumentFromStream.run(SampleFiles.INPUT_PDF);
        Assertions.assertThat(path).exists();
    }
}