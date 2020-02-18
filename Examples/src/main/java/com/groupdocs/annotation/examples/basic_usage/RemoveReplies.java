package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.options.LoadOptions;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates how to remove replies from annotated document
 * </p>
 */
public class RemoveReplies {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("RemoveRepliesById", FilenameUtils.getExtension(Constants.INPUT));
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setImportAnnotations(true);

        // NOTE: Input document already contain annotations with replies
        final Annotator annotator = new Annotator(Constants.ANNOTATED_WITH_REPLIES_NEW, loadOptions);

        // Obtain annotations collection from document
        List<AnnotationBase> annotations = annotator.get();
        // Remove first reply by index
        annotations.get(0).getReplies().remove(0);

        // Save changes
        annotator.update(annotations);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
