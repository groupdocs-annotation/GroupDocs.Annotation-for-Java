---
id: groupdocs-annotation-for-java-20-2-release-notes
url: annotation/java/groupdocs-annotation-for-java-20-2-release-notes
title: GroupDocs.Annotation for Java 20.2 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}
This page contains release notes for GroupDocs.Annotation for Java 20.2
{{< /alert >}}{{< alert style="danger" >}}
Breaking changes
In this version we're introducing new public API which was designed to be simple and easy to use. For more details about new API please check [Migration Notes]({{< ref "annotation/java/developer-guide/migration-notes.md" >}}) and [Developer Guide](https://docs.groupdocs.com/display/annotationjava/Developer+Guide) sections.
{{< /alert >}}

## Major Features
In this version Below the list of most notable changes in release of GroupDocs.Annotation for Java 20.2:
*   Ability to generate document page thumbnails 
*   Implemented ability to add ellipse annotation to different formats
*   Implemented angled watermarks for different formats
*   Implemented multi-paged TIFF annotation
*   Fixed errors in some methods in trial mode
*   Implemented link annotation in PDF, Presentations, Word formats
*   Fixed several bugs and issues  
      
    
## Full List of Issues Covering all Changes in this Release
| Key | Summary | Issue Type |
| --- | --- | --- |
| ANNOTATIONNET-851 | Add Thumbnails of the selected document | Feature |
| ANNOTATIONNET-869  | Implement ability to add ellipse annotation to PDF | Feature |
| ANNOTATIONNET-870  | Implement ability to add ellipse annotation to Words | Feature |
| ANNOTATIONNET-871  | Implement ability to add ellipse annotation to Presentations | Feature |
| ANNOTATIONNET-872  | Implement ability to add ellipse annotation to Images | Feature |
| ANNOTATIONNET-873  | Implement ability to add ellipse annotation to Spreadsheets | Feature |
| ANNOTATIONNET-876  | Implement angled watermarks for PDF | Feature |
| ANNOTATIONNET-877  | Implement angled watermarks for Presentations | Feature |
| ANNOTATIONNET-897 | Implement working with multi-page TIFF | Feature |
| ANNOTATIONNET-904   | Add GetPage convert options for multi-page TIF / TIFF | Feature |
| ANNOTATIONNET-905  | Implement ability to add ellipse annotation to Diagrams | Feature |
| ANNOTATIONNET-919  | Implement angled watermarks for Spreadsheets | Feature |
| ANNOTATIONNET-920  | Implement angled watermarks for Images | Feature |
| ANNOTATIONNET-922  | Implement angled watermarks for Diagrams | Feature |
| ANNOTATIONNET-941 | Implement Link annotation for Presentations | Feature |
| ANNOTATIONNET-942 | Implement Link annotation for PDF | Feature |
| ANNOTATIONNET-943 | Implement Link annotation for Words | Feature |
| ANNOTATIONNET-1011 | Add supporting another Presentations formats: PPTM, POTX, POTM, PPSM | Feature |
| ANNOTATIONNET-1037 | Credit based billing for Metered license | Feature |
| ANNOTATIONNET-964 | GetPdfFile method doesn't implement converting documents with password | Improvement |
| ANNOTATIONNET-843 | Only first page is saved in output when Multi-Tiff file is annotated | Bug |
| ANNOTATIONNET-898 | Import annotations for Images doesn't close stream | Bug |
| ANNOTATIONNET-899 | AnnotationImageHandler.GetDocumentInfo exception in trial mode | Bug |
| ANNOTATIONNET-914 | Annotation not apply if page number not defined in Words | Bug |
| ANNOTATIONNET-918 | PenWidht and PenColor annotation properties can't be applied in Words | Bug |
| ANNOTATIONNET-923 | Comments can't be set to shapes in Presentations | Bug |
| ANNOTATIONNET-950 | Remove annotations fails with Spreadsheets document | Bug |
| ANNOTATIONNET-952 | Documents with password are not converted to PDF | Bug |
| ANNOTATIONNET-963 | GetPdfFile method returns broken file | Bug |
| ANNOTATIONNET-965 | ImportAnnotations method doesn't close source stream for TIFF files | Bug |
| ANNOTATIONNET-986 | Issue with getting document info in trial mode | Bug |
| ANNOTATIONNET-987 | Export annotations to tiff file issue | Bug |
| ANNOTATIONNET-986 | Issue with getting document info in trial mode | Bug |
| ANNOTATIONNET-987 | Export annotations to tiff file issue | Bug |
| ANNOTATIONJAVA-1142  | Text annotation doesn't add in XLS file | Bug |
| ANNOTATIONJAVA-1164  | Annotating an empty cell | Bug |
| ANNOTATIONJAVA-1165  | Cannot add text annotation into XLS file | Bug |
| ANNOTATIONJAVA-1171  | Annotation added in wrong place in XLS file | Bug |
| ANNOTATIONJAVA-1176  | Null pointer exception while annotating TIFF file | Bug |
| ANNOTATIONJAVA-1215  | DocumentType is null | Bug |
| ANNOTATIONJAVA-1216  | Cannot get file not from a storage path | Bug |
| ANNOTATIONJAVA-1244 | Cannot open doc with password | Bug |
| ANNOTATIONJAVA-1248  | Cannot remove polyline annotation in pptx file | Bug |
| ANNOTATIONJAVA-1249  | Wrong top position for text annotation in pptx | Bug |
| ANNOTATIONJAVA-1250  | Cannot add text replacement annotation in word file | Bug |
| ANNOTATIONJAVA-1251  | Comments for distance annotation don't save in word file | Bug |
| ANNOTATIONJAVA-1252  | Text replacement annotation looks like a strikeout | Bug |
| ANNOTATIONJAVA-1253  | Cannot open file without license | Bug |
