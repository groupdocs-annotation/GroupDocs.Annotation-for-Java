package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.StrikeoutAnnotation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DevTest {
    public static void run() {
        // This example demonstrates adding text strikeout annotation.

        // Create an instance of Annotator class
        Annotator annotator = new Annotator(System.getProperty("user.dir") + "\\Resources\\SampleFiles\\dev_sample.pdf");
        try {
            // Create an instance of Reply class and add comments
            Reply reply1 = new Reply();
            reply1.setComment("First comment");
            reply1.setRepliedOn(Calendar.getInstance().getTime());

            Reply reply2 = new Reply();
            reply2.setComment("Second comment");
            reply2.setRepliedOn(Calendar.getInstance().getTime());

            java.util.List<Reply> replies = new ArrayList<>();
            replies.add(reply1);
            replies.add(reply2);

            Point point1 = new Point(80, 730);
            Point point2 = new Point(240, 730);
            Point point3 = new Point(80, 650);
            Point point4 = new Point(240, 650);

            List<Point> points = new ArrayList<>();
            points.add(point1);
            points.add(point2);
            points.add(point3);
            points.add(point4);

            // Create an instance of StrikeoutAnnotation class and set options
            StrikeoutAnnotation strikeout;
            strikeout = new StrikeoutAnnotation();
            strikeout.setCreatedOn(Calendar.getInstance().getTime());
            strikeout.setFontColor(65535);
            strikeout.setMessage("This is strikeout annotation");
            strikeout.setOpacity(0.7);
            strikeout.setPageNumber(0);
            strikeout.setPoints(points);
            strikeout.setReplies(replies);

            // Add annotation and save to file
            annotator.add(strikeout);
            annotator.save(System.getProperty("user.dir") + "\\Resources\\Output\\dev.pdf");
        } finally {
            if (annotator != null) {
                annotator.dispose();
            }
        }
    }
}
