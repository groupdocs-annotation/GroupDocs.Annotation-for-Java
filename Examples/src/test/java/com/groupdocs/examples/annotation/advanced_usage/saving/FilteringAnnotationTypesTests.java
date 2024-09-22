package com.groupdocs.examples.annotation.advanced_usage.saving;

import com.groupdocs.examples.annotation.SampleFiles;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FilteringAnnotationTypesTests {

    @Test
    public void testRun() {
        final Path path = FilteringAnnotationTypes.run(SampleFiles.INPUT_PDF);
        Assertions.assertThat(path).exists();
    }
}