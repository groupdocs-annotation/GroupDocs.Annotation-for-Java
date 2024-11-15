package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.User;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding replies to annotation.
 * </p>
 */
public class AddReplies {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddReplies" + obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {

            User user1 = new User();
            user1.setId(1);
            user1.setName("Tom");
            user1.setEmail("somemail@mail.com");

            User user2 = new User();
            user2.setId(2);
            user2.setName("Jack");
            user2.setEmail("somebody@mail.com");

            User user3 = new User();
            user3.setId(3);
            user3.setName("Mike");
            user3.setEmail("somemike@mail.com");

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

            Reply reply1 = new Reply();
            reply1.setId(1);
            reply1.setComment("First comment");
            reply1.setRepliedOn(Calendar.getInstance().getTime());
            reply1.setUser(user1);

            Reply reply2 = new Reply();
            reply2.setId(2);
            reply2.setComment("Second comment");
            reply2.setRepliedOn(Calendar.getInstance().getTime());
            reply2.setUser(user2);

            Reply reply3 = new Reply();
            reply3.setId(3);
            reply3.setComment("Third comment");
            reply3.setRepliedOn(Calendar.getInstance().getTime());
            reply3.setUser(user1);

            Reply reply4 = new Reply();
            reply4.setId(4);
            reply4.setComment("Fourth comment");
            reply4.setRepliedOn(Calendar.getInstance().getTime());
            reply4.setUser(user2);

            Reply reply5 = new Reply();
            reply5.setId(5);
            reply5.setComment("Five comment");
            reply5.setRepliedOn(Calendar.getInstance().getTime());
            reply5.setUser(user3);

            java.util.List<Reply> replies = Arrays.asList(reply1, reply2, reply3, reply4, reply5);

            area.setReplies(replies);
            annotator.add(area);

            annotator.save(outputPath.toString());

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
