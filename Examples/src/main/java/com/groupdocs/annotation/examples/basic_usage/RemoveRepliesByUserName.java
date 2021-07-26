package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.annotationmodels.AnnotationBase;
import com.groupdocs.annotation.options.LoadOptions;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates how to remove replies from annotated document by
 * user name
 * </p>
 */
public class RemoveRepliesByUserName {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("RemoveRepliesByUserName", FilenameUtils.getExtension(Constants.INPUT));
        LoadOptions loadOptions = new LoadOptions();

        // NOTE: Input document already contain annotations with replies
        final Annotator annotator = new Annotator(Constants.ANNOTATED_AREA_REPLIES_5, loadOptions);

        // Obtain annotations collection from document
        List<AnnotationBase> annotations = annotator.get();

        // Remove all replies where author name is "Tom"           
        for (int i = 0; i < annotations.get(0).getReplies().size(); i++) {
            if (annotations.get(0).getReplies().get(i).getUser().getName().toString().equals("Tom")) {
                annotations.get(0).getReplies().remove(i);
            }
        }

        // Save changes
        annotator.update(annotations);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
