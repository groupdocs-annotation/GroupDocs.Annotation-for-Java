package com.groupdocs.annotation.examples.basic_usage.pdf_components;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.PenStyle;
import com.groupdocs.annotation.models.Rectangle;
import com.groupdocs.annotation.models.Reply;
import com.groupdocs.annotation.models.formatspecificcomponents.pdf.DropdownComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AddDropdownComponent {
    public static void run() {
        try(final Annotator annotator = new Annotator(Constants.INPUT_PDF)) {
            DropdownComponent dropdownComponent = new DropdownComponent();
            dropdownComponent.setOptions(new ArrayList<>(Arrays.asList("Item1", "Item2", "Item3")));
            dropdownComponent.setSelectedOption(null);
            dropdownComponent.setPlaceholder("Choose option");
            dropdownComponent.setBox(new Rectangle(100, 100, 100, 100));
            dropdownComponent.setCreatedOn(new Date());
            dropdownComponent.setMessage("This is dropdown component");
            dropdownComponent.setPageNumber(0);
            dropdownComponent.setPenColor(65535);
            dropdownComponent.setPenStyle(PenStyle.DOT);
            dropdownComponent.setPenWidth((byte) 3);

            List<Reply> replies = new ArrayList<>();
            Reply reply1 = new Reply();
            reply1.setComment("First comment");
            reply1.setRepliedOn(new Date());

            Reply reply2 = new Reply();
            reply2.setComment("Second comment");
            reply2.setRepliedOn(new Date());

            replies.add(reply1);
            replies.add(reply2);

            dropdownComponent.setReplies(replies);
            annotator.add(dropdownComponent);
            annotator.save("result_dropdown_component.pdf");
        }
    }
}
