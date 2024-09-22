package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.EllipseAnnotation;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding ellipse annotation.
 * </p>
 */
public class AddEllipseAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddEllipseAnnotation" + obtainExtension(inputFile));

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

            EllipseAnnotation ellipseAnnotation = new EllipseAnnotation();
            ellipseAnnotation.setBackgroundColor(65535);
            ellipseAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            ellipseAnnotation.setCreatedOn(Calendar.getInstance().getTime());
            ellipseAnnotation.setMessage("This is ellipse annotation");
            ellipseAnnotation.setOpacity(0.7);
            ellipseAnnotation.setPageNumber(0);
            ellipseAnnotation.setPenColor(65535);
            ellipseAnnotation.setPenStyle(PenStyle.DOT);
            ellipseAnnotation.setPenWidth((byte) 3);
            ellipseAnnotation.setReplies(replies);

            annotator.add(ellipseAnnotation);

            annotator.save(outputPath.toString());
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
