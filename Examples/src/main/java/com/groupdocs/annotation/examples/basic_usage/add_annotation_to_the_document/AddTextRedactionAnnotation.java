package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.TextRedactionAnnotation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding text redaction annotation.
 * </p>
 */
public class AddTextRedactionAnnotation {

    public static void run() {
        String outputPath = Constants.getOutputFilePath("AddTextStrikeoutAnnotation", FilenameUtils.getExtension(Constants.INPUT));

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

        Point point1 = new Point(80, 730);
        Point point2 = new Point(240, 730);
        Point point3 = new Point(80, 650);
        Point point4 = new Point(240, 650);

        List<Point> points = new ArrayList<Point>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);

        TextRedactionAnnotation textRedaction = new TextRedactionAnnotation();
        textRedaction.setCreatedOn(Calendar.getInstance().getTime());
        textRedaction.setMessage("This is text redaction annotation");
        textRedaction.setPageNumber(0);
        textRedaction.setPoints(points);
        textRedaction.setReplies(replies);
        annotator.add(textRedaction);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
