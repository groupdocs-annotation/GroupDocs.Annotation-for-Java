package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.examples.annotation.SampleFiles;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class RemoveAnnotationFromDocumentTests {

    @Test
//    @Ignore
    public void testRun() {
        final Path path = RemoveAnnotationFromDocument.run(SampleFiles.ANNOTATED_AREA_REPLIES_5);
        Assertions.assertThat(path).exists();
    }
}