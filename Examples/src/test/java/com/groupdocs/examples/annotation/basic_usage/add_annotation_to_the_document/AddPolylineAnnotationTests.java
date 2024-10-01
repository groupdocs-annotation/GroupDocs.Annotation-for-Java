package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.examples.annotation.SampleFiles;
import com.groupdocs.examples.annotation.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class AddPolylineAnnotationTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path path = AddPolylineAnnotation.run(SampleFiles.INPUT_PDF);
        Assertions.assertThat(path).exists();
    }
}