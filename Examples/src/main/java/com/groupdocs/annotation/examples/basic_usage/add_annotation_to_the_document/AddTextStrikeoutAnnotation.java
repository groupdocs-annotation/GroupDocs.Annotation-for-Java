package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.StrikeoutAnnotation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates adding text strikeout annotation.
 * </p>
 */
public class AddTextStrikeoutAnnotation {

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

        StrikeoutAnnotation strikeout = new StrikeoutAnnotation();
        strikeout.setCreatedOn(Calendar.getInstance().getTime());
        strikeout.setFontColor(65535);
        strikeout.setMessage("This is strikeout annotation");
        strikeout.setOpacity(0.7);
        strikeout.setPageNumber(0);
        strikeout.setPoints(points);
        strikeout.setReplies(replies);
        annotator.add(strikeout);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
