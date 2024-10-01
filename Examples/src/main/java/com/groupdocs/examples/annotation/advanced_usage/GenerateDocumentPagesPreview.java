package com.groupdocs.examples.annotation.advanced_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.options.pagepreview.CreatePageStream;
import com.groupdocs.annotation.options.pagepreview.PreviewFormats;
import com.groupdocs.annotation.options.pagepreview.PreviewOptions;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * This example demonstrates annotating generating previews from document
 * </p>
 */
public class GenerateDocumentPagesPreview {

    public static List<Path> run(Path inputFile) {
        final List<Path> pagePaths = new ArrayList<>();
        try (final Annotator annotator = new Annotator(inputFile.toString())) {
            PreviewOptions previewOptions = new PreviewOptions(new CreatePageStream() {
                @Override
                public OutputStream invoke(int pageNumber) {
                    try {
                        final Path outputPagePath = FilesUtils.makeOutputPath("GenerateDocumentPagesPreview" + "_" + pageNumber + ".png");
                        pagePaths.add(outputPagePath);
                        return Files.newOutputStream(outputPagePath);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            previewOptions.setResolution(85);
            previewOptions.setPreviewFormat(PreviewFormats.PNG);
            previewOptions.setPageNumbers(new int[]{1, 2});
            annotator.getDocument().generatePreview(previewOptions);

            final Optional<Path> optionalPath = pagePaths.stream().findFirst();
            optionalPath.ifPresent(path -> System.out.println("\nDocument previews generated successfully.\nCheck output: " + path.getParent()));
            return pagePaths;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
