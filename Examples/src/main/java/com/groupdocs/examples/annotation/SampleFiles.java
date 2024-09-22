package com.groupdocs.examples.annotation;

import java.nio.file.Path;

import static com.groupdocs.examples.annotation.utils.FilesUtils.makeFilesPath;

public interface SampleFiles {
    Path INPUT_PDF = makeFilesPath("input.pdf");
    Path INPUT_DOC = makeFilesPath("sample.docx");
    Path INPUT_CELL = makeFilesPath("input.xlsx");
    Path ANNOTATED_AREA_REPLIES_5 = makeFilesPath("annotated_area_replies_5.pdf");
    Path ANNOTATED_WITH_REPLIES_NEW = makeFilesPath("annotated_with_replies_new.pdf");
    Path INPUT_PROTECTED = makeFilesPath("input_protected.pdf");
}
