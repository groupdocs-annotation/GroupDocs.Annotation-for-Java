package com.groupdocs.examples.annotation.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.PolylineAnnotation;
import com.groupdocs.examples.annotation.utils.FailureRegister;
import com.groupdocs.examples.annotation.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;

import static com.groupdocs.examples.annotation.utils.FilesUtils.obtainExtension;

/**
 * <p>
 * This example demonstrates adding polyline annotation.
 * </p>
 */
public class AddPolylineAnnotation {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddLinkAnnotation" + obtainExtension(inputFile));

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

            PolylineAnnotation polylineAnnotation = new PolylineAnnotation();
            polylineAnnotation.setBox(new Rectangle(250, 35, 102, 12));
            polylineAnnotation.setCreatedOn(Calendar.getInstance().getTime());
            polylineAnnotation.setMessage("This is polyline annotation");
            polylineAnnotation.setOpacity(0.7);
            polylineAnnotation.setPageNumber(0);
            polylineAnnotation.setPenColor(65535);
            polylineAnnotation.setPenStyle(PenStyle.DOT);
            polylineAnnotation.setPenWidth((byte) 3);
            polylineAnnotation.setReplies(replies);
            polylineAnnotation.setSvgPath("M250.8280751173709,48.209295774647885l0.6986854460093896,0l0.6986854460093896,-1.3973708920187793l0.6986854460093896,0l0.6986854460093896,-1.3973708920187793l1.3973708920187793,-0.6986854460093896l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0l2.096056338028169,-1.3973708920187793l3.493427230046948,-1.3973708920187793l0.6986854460093896,-0.6986854460093896l1.3973708920187793,-1.3973708920187793l0.6986854460093896,0l1.3973708920187793,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0l0,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,0l0,-0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l2.096056338028169,-0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,0l1.3973708920187793,0l1.3973708920187793,0l2.096056338028169,0l5.589483568075117,0l1.3973708920187793,0l2.096056338028169,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l1.3973708920187793,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0l2.096056338028169,1.3973708920187793l0.6986854460093896,0l0.6986854460093896,0l0,0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0.6986854460093896l0,0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0.6986854460093896l1.3973708920187793,0.6986854460093896l3.493427230046948,0.6986854460093896l1.3973708920187793,0.6986854460093896l2.096056338028169,0.6986854460093896l1.3973708920187793,0.6986854460093896l1.3973708920187793,0l1.3973708920187793,0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l2.7947417840375586,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0");

            annotator.add(polylineAnnotation);

            annotator.save(outputPath.toString());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }

        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}