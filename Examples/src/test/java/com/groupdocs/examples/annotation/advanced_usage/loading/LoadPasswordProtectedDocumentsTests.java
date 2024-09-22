package com.groupdocs.examples.annotation.advanced_usage.loading;

import com.groupdocs.examples.annotation.SampleFiles;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class LoadPasswordProtectedDocumentsTests {

    @Test
    public void testRun() {
        final Path path = LoadPasswordProtectedDocuments.run(SampleFiles.INPUT_PROTECTED);
        Assertions.assertThat(path).exists();
    }
}