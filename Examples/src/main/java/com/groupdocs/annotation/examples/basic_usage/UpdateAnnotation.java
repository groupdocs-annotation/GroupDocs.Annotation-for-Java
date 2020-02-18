package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.AreaAnnotation;
import com.groupdocs.annotation.options.LoadOptions;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.io.FilenameUtils;

/**
 * <p>
 * This example demonstrates how to update annotation
 * </p>
 */
public class UpdateAnnotation {

    public static void run() {

        String outputPath = Constants.getOutputFilePath("UpdateAnnotation", FilenameUtils.getExtension(Constants.INPUT));

        final Annotator annotator = new Annotator(Constants.INPUT);

        Reply reply1 = new Reply();
        reply1.setComment("Original first comment");
        reply1.setRepliedOn(Calendar.getInstance().getTime());

        Reply reply2 = new Reply();
        reply2.setComment("Original second comment");
        reply2.setRepliedOn(Calendar.getInstance().getTime());

        java.util.List<Reply> replies = new ArrayList<Reply>();
        replies.add(reply1);
        replies.add(reply2);

        AreaAnnotation original = new AreaAnnotation();
        original.setId(1);
        original.setBackgroundColor(65535);
        original.setBox(new Rectangle(100, 100, 100, 100));
        original.setCreatedOn(Calendar.getInstance().getTime());
        original.setMessage("This is original annotation");
        original.setReplies(replies);
        // add original annotation
        annotator.add(original);
        annotator.save(outputPath);

        annotator.dispose();

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setImportAnnotations(true);

        // open annotated document
        final Annotator annotator1 = new Annotator(outputPath, loadOptions);

        Reply reply3 = new Reply();
        reply3.setComment("Updated first comment");
        reply3.setRepliedOn(Calendar.getInstance().getTime());

        Reply reply4 = new Reply();
        reply4.setComment("Updated second comment");
        reply4.setRepliedOn(Calendar.getInstance().getTime());

        java.util.List<Reply> replies1 = new ArrayList<Reply>();
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
        // update annotation
        annotator1.update(updated);
        annotator1.save(outputPath);

        annotator1.dispose();

        System.out.println("\nDocument saved successfully.\nCheck output in " + outputPath);
    }
}