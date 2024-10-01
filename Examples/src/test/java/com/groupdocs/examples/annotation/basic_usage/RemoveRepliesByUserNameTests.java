package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.examples.annotation.SampleFiles;
import com.groupdocs.examples.annotation.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class RemoveRepliesByUserNameTests extends TestsSetUp {

    @Test
//    @Ignore
    public void testRun() {
        final Path path = RemoveRepliesByUserName.run(SampleFiles.ANNOTATED_AREA_REPLIES_5);
        Assertions.assertThat(path).exists();
    }
}