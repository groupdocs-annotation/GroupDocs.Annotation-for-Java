package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.ArrowAnnotation;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding arrow annotation.
 * </p>
 */
public class AddArrowAnnotation {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("AddArrowAnnotation", FilenameUtils.getExtension(Constants.INPUT));

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

        ArrowAnnotation arrow = new ArrowAnnotation();
        arrow.setBox(new Rectangle(100, 100, 100, 100));
        arrow.setCreatedOn(Calendar.getInstance().getTime());
        arrow.setMessage("This is arrow annotation");
        arrow.setOpacity(0.7);
        arrow.setPageNumber(0);
        arrow.setPenColor(65535);
        arrow.setPenStyle(PenStyle.DOT);
        arrow.setPenWidth((byte) 3);
        arrow.setReplies(replies);
        annotator.add(arrow);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
