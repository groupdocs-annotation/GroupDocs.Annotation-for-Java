package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.LinkAnnotation;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding link annotation.
 * </p>
 */
public class AddLinkAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddLinkAnnotation" + obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {

            Reply reply1 = new Reply();
            reply1.setComment("First comment");
            reply1.setRepliedOn(Calendar.getInstance().getTime());

            Reply reply2 = new Reply();
            reply2.setComment("Second comment");
            reply2.setRepliedOn(Calendar.getInstance().getTime());

            List<Reply> replies = new ArrayList<Reply>();
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

            LinkAnnotation linkAnnotation = new LinkAnnotation();
            linkAnnotation.setCreatedOn(Calendar.getInstance().getTime());
            linkAnnotation.setMessage("This is link annotation");
            linkAnnotation.setOpacity(0.7);
            linkAnnotation.setPageNumber(0);
            linkAnnotation.setPoints(points);
            linkAnnotation.setReplies(replies);
            linkAnnotation.setUrl("https://www.google.com");

            annotator.add(linkAnnotation);

            annotator.save(outputPath.toString());
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
