package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.examples.annotation.SampleFiles;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class UpdateAnnotationTests {

    @Test
    public void testRun() {
        final Path path = UpdateAnnotation.run(SampleFiles.INPUT_PDF);
        Assertions.assertThat(path).exists();
    }
}