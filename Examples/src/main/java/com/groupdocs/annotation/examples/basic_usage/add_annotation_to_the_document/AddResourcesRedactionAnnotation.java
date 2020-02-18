package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.ResourcesRedactionAnnotation;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding resources redaction annotation.
 * </p>
 */
public class AddResourcesRedactionAnnotation {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("AddResourcesRedactionAnnotation", FilenameUtils.getExtension(Constants.INPUT));

        final Annotator annotator = new Annotator(Constants.INPUT);

        Reply reply1 = new Reply();
        reply1.setComment("First comment");
        reply1.setRepliedOn(Calendar.getInstance().getTime());

        Reply reply2 = new Reply();
        reply2.setComment("Second comment");
        reply2.setRepliedOn(Calendar.getInstance().getTime());

        java.util.List<Reply> replies = new ArrayList<Reply>();
        replies.add(reply1);
        replies.add(reply2);

        ResourcesRedactionAnnotation resourcesRedaction = new ResourcesRedactionAnnotation();
        resourcesRedaction.setBox(new Rectangle(100, 100, 100, 100));
        resourcesRedaction.setCreatedOn(Calendar.getInstance().getTime());
        resourcesRedaction.setMessage("This is resources redaction annotation");
        resourcesRedaction.setPageNumber(0);
        resourcesRedaction.setReplies(replies);
        annotator.add(resourcesRedaction);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
