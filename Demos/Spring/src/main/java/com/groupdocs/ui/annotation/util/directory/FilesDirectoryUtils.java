package com.groupdocs.ui.annotation.util.directory;

import com.groupdocs.ui.annotation.config.AnnotationConfiguration;

public class FilesDirectoryUtils { /*implements IDirectoryUtils { */

    private final AnnotationConfiguration AnnotationConfiguration;

    /**
     * <p>
     * Constructor
     * </p>
     *
     * @param annotationConfiguration
     */
    public FilesDirectoryUtils(AnnotationConfiguration annotationConfiguration) {
        AnnotationConfiguration = annotationConfiguration;
    }

    /**
     * <p>
     * Get path
     * </p>
     *
     * @return string
     */
    public final String getPath() {
        return AnnotationConfiguration.getFilesDirectory();
    }
}