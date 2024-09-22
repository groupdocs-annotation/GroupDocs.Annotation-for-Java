package com.groupdocs.examples.annotation.basic_usage;

import com.groupdocs.annotation.options.FileType;

import java.util.List;

/**
 * <p>
 * This example demonstrates file types support
 * </p>
 */
public class GetSupportedFileFormats {

    public static List<FileType> run() {

        List<FileType> fileTypes = FileType.getSupportedFileTypes();
        final StringBuffer stringBuffer = new StringBuffer();
        for (FileType fileType : fileTypes) {
            stringBuffer.append(fileType.getFileFormat()).append(" (").append(fileType.getExtension()).append("), ");
        }
        stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length() - 1);
        System.out.println(stringBuffer);

        System.out.println("\nSupported file types retrieved successfully.");
        return fileTypes;
    }
}
