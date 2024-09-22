package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.examples.annotation.SampleFiles;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class RemoveRepliesTests {

    @Test
    public void testRun() {
        final Path path = RemoveReplies.run(SampleFiles.INPUT_PDF);
        Assertions.assertThat(path).exists();
    }
}