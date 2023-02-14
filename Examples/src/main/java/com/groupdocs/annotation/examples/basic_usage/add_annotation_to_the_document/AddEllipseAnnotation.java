package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.EllipseAnnotation;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding ellipse annotation.
 * </p>
 */
public class AddEllipseAnnotation {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("AddLinkAnnotation", FilenameUtils.getExtension(Constants.INPUT));

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

        EllipseAnnotation ellipse = new EllipseAnnotation();
        ellipse.setBackgroundColor(65535);
        ellipse.setBox(new Rectangle(100, 100, 100, 100));
        ellipse.setCreatedOn(Calendar.getInstance().getTime());
        ellipse.setMessage("This is ellipse annotation");
        ellipse.setOpacity(0.7);
        ellipse.setPageNumber(0);
        ellipse.setPenColor(65535);
        ellipse.setPenStyle(PenStyle.DOT);
        ellipse.setPenWidth((byte) 3);
        ellipse.setReplies(replies);
        annotator.add(ellipse);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
