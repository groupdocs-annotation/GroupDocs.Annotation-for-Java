package com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class LoadDocumentFromUrlTests {

    @Test
    public void testRun() {
        final String url = "https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/blob/master/Examples/Resources/SampleFiles/input.pdf?raw=true";
        final Path path = LoadDocumentFromUrl.run(url);
        Assertions.assertThat(path).exists();
    }
}