package com.groupdocs.annotation.examples.basic_usage.add_annotation_to_the_document;

import com.groupdocs.annotation.Annotator;
import com.groupdocs.annotation.examples.Constants;
import com.groupdocs.annotation.models.annotationmodels.SearchTextFragment;

public class AddSearchTextAnnotation {
    public static void run() {
        try(final Annotator annotator = new Annotator(Constants.INPUT_PDF)){
            SearchTextFragment searchTextFragment = new SearchTextFragment();
            searchTextFragment.setText("Welcome to GroupDocs");//If the document does not contain this text, nothing will be highlighted
            searchTextFragment.setFontSize(10.);
            searchTextFragment.setFontFamily("Calibri");
            searchTextFragment.setFontColor(65535);
            searchTextFragment.setBackgroundColor(16761035);
            annotator.add(searchTextFragment);
            annotator.save("result_add_search_text.pdf");
        }
    }
}
