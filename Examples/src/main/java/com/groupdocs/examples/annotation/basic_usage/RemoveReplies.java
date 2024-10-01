package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.options.LoadOptions;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.List;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates how to remove replies from annotated document
 * </p>
 */
public class RemoveReplies {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("RemoveRepliesById" + obtainExtension(inputFile));
        LoadOptions loadOptions = new LoadOptions();

        // NOTE: Input document already contain annotations with replies
        try (final Annotator annotator = new Annotator(inputFile.toString(), loadOptions)) {

            // Obtain annotations collection from document
            List<AnnotationBase> annotations = annotator.get();
            // Remove first reply by index
            if (!annotations.isEmpty()) {
                annotations.get(0).getReplies().remove(0);
            }

            // Save changes
            annotator.update(annotations);
            annotator.save(outputPath.toString());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
