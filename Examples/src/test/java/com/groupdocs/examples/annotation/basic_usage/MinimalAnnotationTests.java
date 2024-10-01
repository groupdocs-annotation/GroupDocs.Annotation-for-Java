package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.examples.annotation.SampleFiles;
import com.groupdocs.examples.annotation.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class MinimalAnnotationTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path path = MinimalAnnotation.run(SampleFiles.INPUT_DOC);
        Assertions.assertThat(path).exists();
    }
}