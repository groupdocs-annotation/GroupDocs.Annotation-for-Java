package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.ReplacementAnnotation;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding text replacement annotation.
 * </p>
 */
public class AddTextReplacementAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddTextReplacementAnnotation" + obtainExtension(inputFile));

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

            Point point1 = new Point(80, 730);
            Point point2 = new Point(240, 730);
            Point point3 = new Point(80, 650);
            Point point4 = new Point(240, 650);

            java.util.List<Point> points = Arrays.asList(point1, point2, point3, point4);

            ReplacementAnnotation replacement = new ReplacementAnnotation();
            replacement.setCreatedOn(Calendar.getInstance().getTime());
            replacement.setFontColor(65535);
            replacement.setFontSize(8.0d);
            replacement.setMessage("This is replacement annotation");
            replacement.setOpacity(0.7d);
            replacement.setPageNumber(0);
            replacement.setPoints(points);
            replacement.setReplies(replies);
            replacement.setTextToReplace("replaced text");

            annotator.add(replacement);

            annotator.save(outputPath.toString());
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
