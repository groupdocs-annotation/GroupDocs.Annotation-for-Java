package com.groupdocs.ui.annotation.util.directory;

import com.groupdocs.ui.annotation.config.AnnotationConfiguration;

/**
 * DirectoryUtils
 * Compare and sort file types - folders first
 * @author Aspose Pty Ltd
 */
public class DirectoryUtils {
    private FilesDirectoryUtils filesDirectory;

    /**
     * Constructor
     * @param annotationConfiguration
     */
    public DirectoryUtils(AnnotationConfiguration annotationConfiguration){
        filesDirectory = new FilesDirectoryUtils(annotationConfiguration);
    }

    /**
     * Get files directory - path where all documents for signing are stored
     * @return FilesDirectoryUtils
     */
    public FilesDirectoryUtils getFilesDirectory() {
        return filesDirectory;
    }
}
