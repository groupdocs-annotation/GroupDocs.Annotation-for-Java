---
id: groupdocs-annotation-for-java-19-4-release-notes
url: annotation/java/groupdocs-annotation-for-java-19-4-release-notes
title: GroupDocs.Annotation for Java 19.4 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Annotation for Java 19.4{{< /alert >}}

## Major Features

Below is the list of most notable changes in release of GroupDocs.Annotation for Java:

*   Implement watermark annotation for Words
*   Add cleanup for text replacement in Words
*   Improve text annotations in Slides
*   Improve shape processing in Diagrams for text annotations
*   Fixed SvgPath parsing
*   Implement export import and cleanup functionality for Cells format
*   Added new types of annotations for Cells
    *   Text Annotation
    *   Watermark
    *   Resource Redaction
    *   Text Replacement

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| ANNOTATIONNET-700 | Implement watermark annotation for Words | New Feature |
| ANNOTATIONNET-699 | Implement TextReplacement annotation for Cells | New Feature |
| ANNOTATIONNET-705 | Implement text annotations for Cells | New Feature |
| ANNOTATIONNET-702 | Implement Watermark annotation for Cells | New Feature |
| ANNOTATIONNET-701 | Implement ResourceRedation annotation for Cells | New Feature |
| ANNOTATIONNET-724 | Add cleanup for text replacement in Words | New Feature |
| ANNOTATIONNET-752 | Add the ability to apply text annotations without changing the color | New Feature |
| ANNOTATIONNET-751 | Add reviewer rights management for operations with replies. | New Feature |
| ANNOTATIONNET-750 | Add the ability to set text annotations transparency for Diagrams | New Feature |
| ANNOTATIONNET-737 | Add creating Arrow annotation with AnnotationInfo.Box in PDF | New Feature |
| ANNOTATIONNET-791 | Implement TextReplacement in Slides | New Feature |
| ANNOTATIONNET-798 | Implement font family support for TextReplacement | New Feature |
| ANNOTATIONNET-812 | Implement export only pages that contains annotations | New Feature |
| ANNOTATIONNET-813 | Implement Export document with specific annotation type | New Feature |
| ANNOTATIONNET-814 | Export specific pages range of document | New Feature |
| ANNOTATIONNET-815 | Add possibility to retrieve pages without annotations | New Feature |
| ANNOTATIONNET-727 | Improve text annotations in Slides | Improvement |
| ANNOTATIONNET-720 | Improve shape processing in Diagrams for text annotations | Improvement |
| ANNOTATIONNET-745 | Security improvements update | Improvement |
| ANNOTATIONNET-756 | Change default TextField background color for Diagrams and Slides | Improvement |
| ANNOTATIONNET-755 | Display border for TextField annotation in Images | Improvement |
| ANNOTATIONNET-754 | Change TextField default background color in PDF | Improvement |
| ANNOTATIONNET-744 | Improve applying annotations properties for Diagrams | Improvement |
| ANNOTATIONNET-736 | Change applying comments with replies | Improvement |
| ANNOTATIONNET-740 | Add FontColor cleanup in Slides | Improvement |
| ANNOTATIONNET-741 | Implement PenStyle property for Words | Improvement |
| ANNOTATIONNET-742  | Implement PenStyle property for Cells | Improvement |
| ANNOTATIONNET-743 | Implement PenStyle property for Diagrams | Improvement |
| ANNOTATIONNET-744 | Implement PenStyle property for PDF | Improvement |
| ANNOTATIONNET-745 | Implement PenStyle property for Slides | Improvement |
| ANNOTATIONNET-756 | Implement PenStyle property in Images | Improvement |
| ANNOTATIONNET-806 | Ensured and updated GroupDocs.Annotation code is thread-safe | Improvement |
| ANNOTATIONNET-811 | Add text replacement for grouped shapes | Improvement |
| ANNOTATIONJAVA-1124 | Managing different versions of annotated file | Improvement |
| ANNOTATIONJAVA-1123 | Document Annotation With Native Mobile Apps | Improvement |
| ANNOTATIONJAVA-1111 | Adding creator information with annotation is not saved | Improvement |
| ANNOTATIONNET-729 | Bug with SvgPath parsing | Bug |
| ANNOTATIONNET-748 | Bug with manual date changing for Diagrams | Bug |
| ANNOTATIONNET-738 | Bug with cleaning multiple different annotations for Pdf | Bug |
| ANNOTATIONNET-752 | .NET version: TIFF/Multi TIFF file is either corrupted or black and white when annotated | Bug |
| ANNOTATIONNET-748 | Fix for unstable sorting for Slides and Diagrams | Bug |
| ANNOTATIONNET-807 | Fix time format bug for Slides | Bug |
| ANNOTATIONNET-804 | Fix converting int to PDF.Color | Bug |
| ANNOTATIONNET-799 | Fix annotation point position for TextReplacement on Slides | Bug |
| ANNOTATIONNET-793 | Issue with CleanUp on PDF document | Bug |
| ANNOTATIONNET-819  | AnnotationImageHandler.GetDocumentInfo method in trial mode throws exception | Bug |
| ANNOTATIONNET-821  | Bug during apply annotation to empty document in Cells | Bug |
| ANNOTATIONNET-82  | NotSupportedException exception when pass password parameter for Images | Bug |
| ANNOTATIONJAVA-1121  | Exception is thrown while adding annotation in Diagrams | Bug |
| ANNOTATIONJAVA-1125  | Exception occurred while adding Distance, Point and Polyline annotation to Word doc | Bug |
| ANNOTATIONJAVA-1143  | Wrong size of text annotation and disappearing the annotation in word file | Bug |
| ANNOTATIONJAVA-1141 | Exception occurred while annotate pdf,word file in total sample | Bug |
| ANNOTATIONJAVA-1139 | Exception occurred while remove annotations from pdf file | Bug |
| ANNOTATIONJAVA-1130 | java.lang.NoSuchFieldError exception when applying license | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Annotation for Java 19.4. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Annotation which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  **Export page range:**
    To export specific pages  you should just to setup *ExportOptions *class, and then export as before.
    
    ```java
    ExportOptions options = new ExportOptions();
    options.setFirstPage(5);
    options.setLastPage(8);
    ```
    Result: will be exported document pages started from page 6 and ending page 9.
    
    ```java
    ExportOptions options = new ExportOptions();
    options.setFirstPage(4);
    options.setLastPage(4);
    ```
    
    Result: document will contain only one page with index 5.
    Note: there will be no effect if:
    *   FirstPage > LastPage;
    *   If FirstPage or / and LastPage < 0
    *   If LastPage > document pages number
        
2.  **Export only pages with annotations:**
    
    To export only pages that contains annotations you should specify *AnnotatedPages = true *of *ExportOptions *class.
    
    ```java
    ExportOptions options = new ExportOptions();
    options.setAnnotatedPages(true);
    ```
    
    Result: document that contains only annotated pages.
    
    
    ```java
    ExportOptions options = new ExportOptions();
    options.setFirstPage(5);
    options.setLastPage(8);
    options.setAnnotatedPages(true);
    ```
    
    Result: document that contains only annotated pages inside this page range. If there not annotated pages, then document will contains only page from specific range.
    
3.  **Export annotations of specific types:**
    
    ```java
    List<Byte> typesToExport = new ArrayList<Byte>();
    typesToExport.add(AnnotationType.Area);
    typesToExport.add(AnnotationType.Polyline);
    ExportOptions options = new ExportOptions();
    options.setAnnotationTypes(typesToExport);
    ```
    Result: document that contains only Area and Polyline annotations.
    
    ```java
    List<Byte> typesToExport = new ArrayList<Byte>();
    typesToExport.add(AnnotationType.Area);
    ExportOptions options = new ExportOptions();
    options.setAnnotationTypes(typesToExport);
    options.setAnnotatedPages(true);
    ```
    
    Result: document that contains only annotated pages with only Area annotations.
    
    
    ```java
    List<Byte> typesToExport = new ArrayList<Byte>();
    typesToExport.add(AnnotationType.Area);
    ExportOptions options = new ExportOptions();
    options.setAnnotationTypes(typesToExport);
    options.setAnnotatedPages(true);
    options.setFirstPage(5);
    options.setLastPage(8);
    ```
    
    Result: document that contains only annotated pages with only Area annotations inside range from 5 to 8th pag. If no Area annotation inside this range, then document just contains pages from 5 to 8.