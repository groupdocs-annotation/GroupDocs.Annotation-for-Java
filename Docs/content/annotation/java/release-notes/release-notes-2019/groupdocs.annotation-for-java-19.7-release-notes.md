---
id: groupdocs-annotation-for-java-19-7-release-notes
url: annotation/java/groupdocs-annotation-for-java-19-7-release-notes
title: GroupDocs.Annotation for Java 19.7 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Annotation for Java 19.7{{< /alert >}}

## Major Features

Below is the list of most notable changes in release of GroupDocs.Annotation for Java 19.7:

*   Add Thumbnails of the selected document
*   Implement ability to add ellipse annotation to different formats
*   Implement angled watermarks for different formats
*   Annotation not apply if page number not defined in Words and Cells
*   Implement working with mutipage TIFF
*   Fixed errors in some methods in trial mode

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| ANNOTATIONNET-851 | Add Thumbnails of the selected document | Feature |
| ANNOTATIONNET-869  | Implement ability to add ellipse annotation to PDF | Feature |
| ANNOTATIONNET-870  | Implement ability to add ellipse annotation to Words | Feature |
| ANNOTATIONNET-871  | Implement ability to add ellipse annotation to Slides | Feature |
| ANNOTATIONNET-872  | Implement ability to add ellipse annotation to Images | Feature |
| ANNOTATIONNET-873  | Implement ability to add ellipse annotation to Cells | Feature |
| ANNOTATIONNET-876  | Implement angled watermarks for PDF | Feature |
| ANNOTATIONNET-877  | Implement angled watermarks for Slides | Feature |
| ANNOTATIONNET-897 | Implement working with mutipage TIFF | Feature |
| ANNOTATIONNET-904   | Add GetPage convert options for multipage TIF / TIFF | Feature |
| ANNOTATIONNET-905  | Implement ability to add ellipse annotation to Diagrams | Feature |
| ANNOTATIONNET-919  | Implement angled watermarks for Cells | Feature |
| ANNOTATIONNET-920  | Implement angled watermarks for Images | Feature |
| ANNOTATIONNET-922  | Implement angled watermarks for Diagrams | Feature |
| ANNOTATIONNET-843 | Only first page is saved in output when Multi-Tiff file is annotated | Bug |
| ANNOTATIONNET-898 | Import annotations for Images doesn't close stream | Bug |
| ANNOTATIONNET-899 | AnnotationImageHandler.GetDocumentInfo exception in trial mode | Bug |
| ANNOTATIONNET-914 | Annotation not apply if page number not defined in Words | Bug |
| ANNOTATIONNET-918 | PenWidht and PenColor annotation properties can't be applied in Words | Bug |
| ANNOTATIONNET-923 | Comments can't be set to shapes in Slides | Bug |
| ANNOTATIONJAVA-111 | TIFF/Multi TIFF file is either corrupted or black and white when annotated | Bug |
| ANNOTATIONJAVA-1189 | Exception occurred when I add a polyline annotation into the file and then try to add a distance annotation | Bug |
| ANNOTATIONJAVA-1134 | Application is consuming 100% resources usage while loading document | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Annotation for Java 19.7. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Annotation which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.   Adding Ellipse annotation.
    
    ```java
    // minimal set of parameters
    AnnotationInfo ellipse = new AnnotationInfo();
    ellipse.setBox(new Rectangle(100, 100.0, 50, 50));
    ellipse.setType(AnnotationType.Ellipse);
    ```
    
2.  GetThumbnail method returns JPEG image stream.  
    Assume we are getting pages from document:
    
    ```java
    List<PageImage> pages = annotationHandler.getPages(document);
     
    // Then if we want get thumbnail we call GetThumbnail() method of PageImage item:
    for (int i = 0; i < pages.size(); i++) {
        InputStream stream = pages.get(i).getThumbnail();
        // do something with stream 
    }
     
    // Default image size was 300x180. If need specified image size, you can pass method parameters:
    // image thumbnails 100x100
    for (int i = 0; i < pages.size(); i++) {
        InputStream stream = pages.get(i).getThumbnail(100, 100);
        // do something with stream 
    }
    ```
    
3.  Added ability to set text watermarks angle.  
    The same as adding Watermark annotation, but you should additionally set Watermark rotation angle by setting AnnotationInfo.Angle property (in degrees)
    
    ```java
    AnnotationInfo annotation = new AnnotationInfo();
    annotation.setType(AnnotationType.Watermark);
    annotation.setAngle(45.0);
    ```
