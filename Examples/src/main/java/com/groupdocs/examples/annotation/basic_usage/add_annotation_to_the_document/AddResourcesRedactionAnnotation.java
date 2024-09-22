package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.ResourcesRedactionAnnotation;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding resources redaction annotation.
 * </p>
 */
public class AddResourcesRedactionAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddResourcesRedactionAnnotation" + obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {

            Reply reply1 = new Reply();
            reply1.setComment("First comment");
            reply1.setRepliedOn(Calendar.getInstance().getTime());

            Reply reply2 = new Reply();
            reply2.setComment("Second comment");
            reply2.setRepliedOn(Calendar.getInstance().getTime());

            java.util.List<Reply> replies = new ArrayList<>();
            replies.add(reply1);
            replies.add(reply2);

            ResourcesRedactionAnnotation resourcesRedactionAnnotation = new ResourcesRedactionAnnotation();
            resourcesRedactionAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            resourcesRedactionAnnotation.setCreatedOn(Calendar.getInstance().getTime());
            resourcesRedactionAnnotation.setMessage("This is resources redaction annotation");
            resourcesRedactionAnnotation.setPageNumber(0);
            resourcesRedactionAnnotation.setReplies(replies);

            annotator.add(resourcesRedactionAnnotation);

            annotator.save(outputPath.toString());
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
