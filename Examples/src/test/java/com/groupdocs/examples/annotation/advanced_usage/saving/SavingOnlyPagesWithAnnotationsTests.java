package com.groupdocs.examples.annotation.advanced_usage.saving;

import com.groupdocs.examples.annotation.SampleFiles;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class SavingOnlyPagesWithAnnotationsTests {

    @Test
    public void testRun() {
        final Path path = SavingOnlyPagesWithAnnotations.run(SampleFiles.INPUT_PDF);
        Assertions.assertThat(path).exists();
    }
}