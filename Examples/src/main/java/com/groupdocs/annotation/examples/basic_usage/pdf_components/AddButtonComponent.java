package com.groupdocs.annotation.examples.basic_usage.pdf_components;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.BorderStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.formatspecificcomponents.pdf.ButtonComponent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddButtonComponent {
    public static void run() {
        try(final Annotator annotator = new Annotator(Constants.INPUT_PDF)) {
            ButtonComponent buttonComponent = new ButtonComponent();
            buttonComponent.setCreatedOn(new Date());
            buttonComponent.setStyle(BorderStyle.DASHED);
            buttonComponent.setMessage("This is button component");
            buttonComponent.setBorderColor(1422623);
            buttonComponent.setPenColor(14527697);
            buttonComponent.setButtonColor(10832612);
            buttonComponent.setPageNumber(0);
            buttonComponent.setBorderWidth(12);
            buttonComponent.setBox(new Rectangle(100, 300, 90, 30));

            Reply reply1 = new Reply();
            reply1.setComment("First comment");
            reply1.setRepliedOn(new Date());

            Reply reply2 = new Reply();
            reply2.setComment("Second comment");
            reply2.setRepliedOn(new Date());

            List<Reply> replies = new ArrayList<>();
            replies.add(reply1);
            replies.add(reply2);

            buttonComponent.setReplies(replies);

            annotator.add(buttonComponent);
            annotator.save("result_button_component.pdf");
        }
    }
}
