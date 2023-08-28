package com.groupdocs.annotation.examples.basic_usage.pdf_components;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.BoxStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.formatspecificcomponents.pdf.CheckBoxComponent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddCheckBoxComponent {
    public static void run() {
        try(final Annotator annotator = new Annotator(Constants.INPUT_PDF)) {
            CheckBoxComponent checkbox = new CheckBoxComponent();
            checkbox.setChecked(true);
            checkbox.setBox(new Rectangle(100, 100, 100, 100));
            checkbox.setPenColor(65535);
            checkbox.setStyle(BoxStyle.STAR);
            Reply reply1 = new Reply();
            reply1.setComment("First comment");
            reply1.setRepliedOn(new Date());

            Reply reply2 = new Reply();
            reply2.setComment("Second comment");
            reply2.setRepliedOn(new Date());

            List<Reply> replies = new ArrayList<>();
            replies.add(reply1);
            replies.add(reply2);

            checkbox.setReplies(replies);

            annotator.add(checkbox);
            annotator.save("result_checkbox_component.pdf");
        }
    }
}
