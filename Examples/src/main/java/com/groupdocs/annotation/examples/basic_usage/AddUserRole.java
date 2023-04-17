package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;

import com.groupdocs.annotation.models.*;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * <p>
 * This example demonstrates adding user role to reply.
 * </p>
 */
public class AddUserRole {
    public static void run() {
        String outputPath = Constants.getOutputFilePath("AddUserRole", FilenameUtils.getExtension(Constants.INPUT_PDF));

        final Annotator annotator = new Annotator(Constants.INPUT_PDF);

        Reply reply1 = new Reply();
        reply1.setComment("This comment will be applied");
        reply1.setRepliedOn(Calendar.getInstance().getTime());
        User user1 = new User(1, "Reviewer", Role.Editor);
        reply1.setUser(user1);

        Reply reply2 = new Reply();
        reply2.setComment("This comment will NOT be applied");
        reply2.setRepliedOn(Calendar.getInstance().getTime());
        User user2 = new User(1, "Member", Role.Viewer);
        reply2.setUser(user2);

        java.util.List<Reply> replies = new ArrayList<>();
        replies.add(reply1);
        replies.add(reply2);

        AreaAnnotation area = new AreaAnnotation();
        area.setBackgroundColor(65535);
        area.setBox(new Rectangle(100, 100, 100, 100));
        area.setCreatedOn(Calendar.getInstance().getTime());
        area.setMessage("This is area annotation");
        area.setOpacity(0.7);
        area.setPageNumber(0);
        area.setPenColor(65535);
        area.setPenStyle(PenStyle.DOT);
        area.setPenWidth((byte) 3);
        area.setReplies(replies);
        annotator.add(area);
        annotator.save(outputPath);

        annotator.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}
