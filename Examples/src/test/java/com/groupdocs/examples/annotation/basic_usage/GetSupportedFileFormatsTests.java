package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.options.FileType;
import com.groupdocs.examples.annotation.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class GetSupportedFileFormatsTests extends TestsSetUp {

    @Test
    public void testRun() {
        final List<FileType> fileTypes = GetSupportedFileFormats.run();
        Assertions.assertThat(fileTypes).hasSize(40);
    }
}