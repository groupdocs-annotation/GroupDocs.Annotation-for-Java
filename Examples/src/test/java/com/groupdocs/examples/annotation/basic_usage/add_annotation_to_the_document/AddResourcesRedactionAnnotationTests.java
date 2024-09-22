package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.examples.annotation.SampleFiles;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class AddResourcesRedactionAnnotationTests {

    @Test
    public void testRun() {
        final Path path = AddResourcesRedactionAnnotation.run(SampleFiles.INPUT_PDF);
        Assertions.assertThat(path).exists();
    }
}