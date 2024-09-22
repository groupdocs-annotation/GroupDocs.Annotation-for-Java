package com.groupdocs.examples.annotation.advanced_usage.loading.loading_documents_from_different_sources;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class LoadDocumentFromFtpTests {
    @Test
    @Ignore
    public void testRun() {
        final Path path = LoadDocumentFromFtp.run("sample.pdf", "localhost");
        Assertions.assertThat(path).exists();
    }
}