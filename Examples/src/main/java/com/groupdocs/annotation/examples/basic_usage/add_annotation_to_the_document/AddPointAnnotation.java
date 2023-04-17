package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.PointAnnotation;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding point annotation.
 * </p>
 */
public class AddPointAnnotation {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("AddPointAnnotation", FilenameUtils.getExtension(Constants.INPUT_PDF));

        final Annotator annotator = new Annotator(Constants.INPUT_PDF);

        Reply reply1 = new Reply();
        reply1.setComment("First comment");
        reply1.setRepliedOn(Calendar.getInstance().getTime());

        Reply reply2 = new Reply();
        reply2.setComment("Second comment");
        reply2.setRepliedOn(Calendar.getInstance().getTime());

        java.util.List<Reply> replies = new ArrayList<Reply>();
        replies.add(reply1);
        replies.add(reply2);

        PointAnnotation point = new PointAnnotation();
        point.setBox(new Rectangle(100, 100, 0, 0));
        point.setCreatedOn(Calendar.getInstance().getTime());
        point.setMessage("This is point annotation");
        point.setPageNumber(0);
        point.setReplies(replies);
        annotator.add(point);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
