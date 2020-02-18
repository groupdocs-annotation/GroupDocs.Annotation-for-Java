package com.groupdocs.annotation.examples.basic_usage;

import com.groupdocs.annotation.options.FileType;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * This example demonstrates file types support
 * </p>
 */
public class GetSupportedFileFormats {

    public static void run() {
        
        List<FileType> fileTypes = FileType.getSupportedFileTypes();
        //foreach to while statements conversion
        Iterator items = (fileTypes).iterator();
        while (items.hasNext()) {
            FileType fileType = (FileType) items.next();
            System.out.println(fileType.getExtension());
        }

        System.out.println("\nSupported file types retrieved successfully.");
    }
}
