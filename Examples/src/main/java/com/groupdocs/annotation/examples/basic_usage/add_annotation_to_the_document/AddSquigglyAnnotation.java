package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.Point;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.annotationmodels.SquigglyAnnotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddSquigglyAnnotation {
    public static void run() {
        try(final Annotator annotator = new Annotator(Constants.INPUT_PDF)){
            SquigglyAnnotation squigglyAnnotation = new SquigglyAnnotation();
            squigglyAnnotation.setCreatedOn(new Date());
            squigglyAnnotation.setFontColor(65535);
            squigglyAnnotation.setBackgroundColor(16761035);
            squigglyAnnotation.setMessage("This is squiggly annotation");
            squigglyAnnotation.setOpacity(0.7);
            squigglyAnnotation.setPageNumber(0);
            squigglyAnnotation.setSquigglyColor(1422623);//Supported only Word and PDF
            List points = new ArrayList<Point>();
            points.add(new Point(80, 730));
            points.add(new Point(240, 730));
            points.add(new Point(80, 650));
            points.add(new Point(240, 650));

            Reply reply1 = new Reply();
            reply1.setComment("First comment");
            reply1.setRepliedOn(new Date());

            Reply reply2 = new Reply();
            reply2.setComment("Second comment");
            reply2.setRepliedOn(new Date());

            List<Reply> replies = new ArrayList<>();
            replies.add(reply1);
            replies.add(reply2);

            squigglyAnnotation.setReplies(replies);

            annotator.add(squigglyAnnotation);
            annotator.save("result_squiggly_annotation.pdf");
        }
    }
}
