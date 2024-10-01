package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.PointAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding point annotation.
 * </p>
 */
public class AddPointAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddPointAnnotation" + obtainExtension(inputFile));

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

            PointAnnotation point = new PointAnnotation();
            point.setBox(new Rectangle(100, 100, 0, 0));
            point.setCreatedOn(Calendar.getInstance().getTime());
            point.setMessage("This is point annotation");
            point.setPageNumber(0);
            point.setReplies(replies);

            annotator.add(point);

            annotator.save(outputPath.toString());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }

        System.out.println("\nDocument saved successfully.\nCheck output:  " + outputPath.getParent());
        return outputPath;
    }
}
