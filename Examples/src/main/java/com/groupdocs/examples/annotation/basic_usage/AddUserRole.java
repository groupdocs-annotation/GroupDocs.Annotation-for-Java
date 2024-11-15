package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.*;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding user role to reply.
 * </p>
 */
public class AddUserRole {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddUserRole" + obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {

            Reply reply1 = new Reply();
            reply1.setComment("This comment will be applied");
            reply1.setRepliedOn(Calendar.getInstance().getTime());
            User user1 = new User(1, "Reviewer", Role.EDITOR);
            reply1.setUser(user1);

            Reply reply2 = new Reply();
            reply2.setComment("This comment will NOT be applied");
            reply2.setRepliedOn(Calendar.getInstance().getTime());
            User user2 = new User(1, "Member", Role.VIEWER);
            reply2.setUser(user2);

            List<Reply> replies = new ArrayList<>();
            replies.add(reply1);
            replies.add(reply2);

            AreaAnnotation areaAnnotation = new AreaAnnotation();
            areaAnnotation.setBackgroundColor(65535);
            areaAnnotation.setBox(new Rectangle(100, 100, 100, 100));
            areaAnnotation.setCreatedOn(Calendar.getInstance().getTime());
            areaAnnotation.setMessage("This is area annotation");
            areaAnnotation.setOpacity(0.7);
            areaAnnotation.setPageNumber(0);
            areaAnnotation.setPenColor(65535);
            areaAnnotation.setPenStyle(PenStyle.DOT);
            areaAnnotation.setPenWidth((byte) 3);
            areaAnnotation.setReplies(replies);

            annotator.add(areaAnnotation);

            annotator.save(outputPath.toString());

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
