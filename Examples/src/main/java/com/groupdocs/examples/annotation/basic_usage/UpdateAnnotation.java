package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.annotation.options.LoadOptions;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates how to update annotation
 * </p>
 */
public class UpdateAnnotation {

    public static Path run(Path inputFile) {
        final Path originOutputPath = FilesUtils.makeOutputPath("UpdateAnnotation-origin" + obtainExtension(inputFile));

        try (final Annotator annotator = new Annotator(inputFile.toString())) {

            Reply reply1 = new Reply();
            reply1.setComment("Original first comment");
            reply1.setRepliedOn(Calendar.getInstance().getTime());

            Reply reply2 = new Reply();
            reply2.setComment("Original second comment");
            reply2.setRepliedOn(Calendar.getInstance().getTime());

            List<Reply> replies = new ArrayList<>();
            replies.add(reply1);
            replies.add(reply2);

            AreaAnnotation original = new AreaAnnotation();
            original.setId(1);
            original.setBackgroundColor(65535);
            original.setBox(new Rectangle(100, 100, 100, 100));
            original.setCreatedOn(Calendar.getInstance().getTime());
            original.setMessage("This is original annotation");
            original.setReplies(replies);

            // Add original annotation
            annotator.add(original);

            annotator.save(originOutputPath.toString());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }

        LoadOptions loadOptions = new LoadOptions();

        final Path updatedOutputPath = FilesUtils.makeOutputPath("UpdateAnnotation-updated" + obtainExtension(inputFile));

        // Open annotated document
        try (final Annotator annotator1 = new Annotator(originOutputPath.toString(), loadOptions)) {

            Reply reply3 = new Reply();
            reply3.setComment("Updated first comment");
            reply3.setRepliedOn(Calendar.getInstance().getTime());

            Reply reply4 = new Reply();
            reply4.setComment("Updated second comment");
            reply4.setRepliedOn(Calendar.getInstance().getTime());

            List<Reply> replies1 = new ArrayList<>();
            replies1.add(reply3);
            replies1.add(reply4);

            // suggest we want change some properties of existed annotation
            AreaAnnotation updated = new AreaAnnotation();
            updated.setId(1);
            updated.setBackgroundColor(255);
            updated.setBox(new Rectangle(0, 0, 50, 200));
            updated.setCreatedOn(Calendar.getInstance().getTime());
            updated.setMessage("This is updated annotation");
            updated.setReplies(replies1);

            annotator1.update(updated);

            annotator1.save(updatedOutputPath.toString());

            System.out.println("\nDocument saved successfully.\nCheck output: " + updatedOutputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return originOutputPath;
    }
}