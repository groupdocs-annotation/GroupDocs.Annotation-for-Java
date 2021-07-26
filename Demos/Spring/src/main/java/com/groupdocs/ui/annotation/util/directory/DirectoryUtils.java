package com.groupdocs.ui.annotation.util.directory;

import com.groupdocs.ui.annotation.config.AnnotationConfiguration;

public class DirectoryUtils {

    public FilesDirectoryUtils FilesDirectory;

    /**
     * <p>
     * Constructor
     * </p>
     *
     * @param annotationConfiguration AnnotationConfiguration
     */
    public DirectoryUtils(AnnotationConfiguration annotationConfiguration) {
        FilesDirectory = new FilesDirectoryUtils(annotationConfiguration);
    }
}