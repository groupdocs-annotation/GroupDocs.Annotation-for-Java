package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.options.LoadOptions;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.List;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates how to remove replies from annotated document by
 * user name
 * </p>
 */
public class RemoveRepliesByUserName {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("RemoveRepliesByUserName" + obtainExtension(inputFile));
        LoadOptions loadOptions = new LoadOptions();

        // NOTE: Input document already contain annotations with replies

        try (final Annotator annotator = new Annotator(inputFile.toString(), loadOptions)) {

            // Obtain annotations collection from document
            List<AnnotationBase> annotations = annotator.get();

            // Remove all replies where author name is "Tom"
            if (!annotations.isEmpty()) {
                annotations.get(0).getReplies().removeIf(reply -> reply.getUser().getName().toString().equals("Tom"));
            }

            annotator.update(annotations);

            annotator.save(outputPath.toString());
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());

        return outputPath;
    }
}
