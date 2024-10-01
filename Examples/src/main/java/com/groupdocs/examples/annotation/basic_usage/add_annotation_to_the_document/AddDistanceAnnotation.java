package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.DistanceAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding distance annotation.
 * </p>
 */
public class AddDistanceAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddDistanceAnnotation" + obtainExtension(inputFile));

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

            DistanceAnnotation distance = new DistanceAnnotation();
            distance.setBox(new Rectangle(200, 150, 200, 30));
            distance.setCreatedOn(Calendar.getInstance().getTime());
            distance.setMessage("This is distance annotation");
            distance.setOpacity(0.7);
            distance.setPageNumber(0);
            distance.setPenColor(65535);
            distance.setPenStyle(PenStyle.DOT);
            distance.setPenWidth((byte) 3);
            distance.setReplies(replies);
            annotator.add(distance);
            annotator.save(outputPath.toString());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
