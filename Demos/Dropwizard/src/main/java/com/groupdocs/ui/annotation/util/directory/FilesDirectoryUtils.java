package com.groupdocs.ui.annotation.util.directory;

import com.groupdocs.ui.annotation.config.AnnotationConfiguration;

/**
 * FilesDirectoryUtils
 * Compare and sort file types - folders first
 * @author Aspose Pty Ltd
 */
public class FilesDirectoryUtils implements IDirectoryUtils {
    private AnnotationConfiguration annotationConfiguration;

    /**
     * Constructor
     * @param annotationConfiguration
     */
    public FilesDirectoryUtils(AnnotationConfiguration annotationConfiguration){
        this.annotationConfiguration = annotationConfiguration;
    }

    /**
     * Get path for files directory
     * @return path of the files directory
     */
    @Override
    public String getPath() {
        return annotationConfiguration.getFilesDirectory();
    }

}
