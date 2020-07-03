---
id: groupdocs-annotation-for-java-17-5-0-release-notes
url: annotation/java/groupdocs-annotation-for-java-17-5-0-release-notes
title: GroupDocs.Annotation for Java 17.5.0 Release Notes
weight: 5
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Annotation for Java 17.5.0{{< /alert >}}

## Major Features

Below the list of improvements, fixed bugs and new features in this regular monthly release of GroupDocs.Annotation for Java. The most notable are:  
*   Add Metered licensing support
*   Implemented DICOM documents annotating 
*   Implemented Otp documents annotating 
*   Implemented DjVu documents annotating
*   Adding annotations to EMF/WMF documents
*   Added Distance Annotations to image documents
*   Implemented CAD documents annotating 
*   Implemented Arrow annotation for images
*   Fixed replies to annotations for Word documents
*   Improving processing CAD files (user able to work with documents with several pages)
*   Improved import annotation for Words document
*   Processing tables, numebered lists and hyperlinks in Words documents
*   Fixed issue on mechanism of annotations detection on special cases for Words documents
*   Implemented ability to annotate Email documents (export only)
*   Added ability to annotate Html documents
*   Implemented import annotations from tables for Words documents

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| ANNOTATIONNET-351 | Implement annotating for DICOM format images | New Feature |
| ANNOTATIONNET-348 | Add Metered licensing support | New Feature |
| ANNOTATIONNET-344 | Implement adding annotations to Otp format | New Feature |
| ANNOTATIONNET-340 | Implement annotating DjVu format | New Feature |
| ANNOTATIONNET-368 | Implement distance annotation for images | New Feature |
| ANNOTATIONNET-367 | Implement annotating EMF/WMF document | New Feature |
| ANNOTATIONNET-363 | Implement CAD documents annotating | New Feature |
| ANNOTATIONNET-361 | Implement adding Arrow annotation to Image documents | New Feature |
| ANNOTATIONNET-380 | Process hyperlinks in tables for Words documents | New Feature |
| ANNOTATIONNET-379 | Processing numbered lists in tables for Words documents | New Feature |
| ANNOTATIONNET-378 | Processing tables in Word documents | New Feature |
| ANNOTATIONNET-393 | Implement GetDocumentInfo from a stream | New Feature |
| ANNOTATIONNET-392 | Implement Html documents annotating | New Feature |
| ANNOTATIONNET-391 | Implement annotating Email format | New Feature |
| ANNOTATIONNET-390 | Implement import annotations in tables for Word | New Feature |
| ANNOTATIONNET-381 | Improve import annotations from Word documents | Improvement |
| ANNOTATIONNET-376 | Improve Annotating CAD files | Improvement |
| ANNOTATIONNET-388 | Refactor annotations export logic | Improvement |
| ANNOTATIONNET-365 | Export to MS-Word exporting the repeated reply comments | Bug |
| ANNOTATIONNET-389 | Fix issues with annotations detection in some special cases in Words documents | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Annotation for Java 17.5.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Annotation which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Added new formats to annotating images article
2.  Adding annotations for EMF/WMF and CAD formats
3.  Adding Distance and Arrow annotations for image
4.  Added ability to get document information from stream
5.  Added annotating Email (export only) (Eml Emlx Msg) documents
6.  Added annotating (export only) Email (Html) documents

### Metered licensing

```java
String storagePath = Utilities.STORAGE_PATH;
        
// Setup Annotation configuration
AnnotationConfig annotationConfig = new AnnotationConfig();
annotationConfig.setStoragePath(storagePath);
 
InputStream cleanPdf = new FileInputStream(Utilities.STORAGE_PATH + File.separator + "SetLicense.TestData.Clear.pdf");
 
// Create new instance of GroupDocs.Annotation.Metered classs
Metered metered = new Metered();
 
// Set public and private key to metered instance
metered.setMeteredKey("**", "**");
 
// Get metered value before usage of the annotation
double amountBefore = Metered.getConsumptionQuantity();
System.out.println("Amount consumed  before: " + amountBefore);
 
//instantiating the annotation handler
AnnotationImageHandler annotator = new AnnotationImageHandler(annotationConfig);
AnnotationInfo pointAnnotation = new AnnotationInfo();
pointAnnotation.setAnnotationPosition(new Point(852.0, 81.0));
pointAnnotation.setBox(new Rectangle(212f, 81f, 142f, 0.0f));
pointAnnotation.setPageNumber(0);
pointAnnotation.setType(AnnotationType.Point);
pointAnnotation.setCreatorName("Anonym A.");
 
List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
annotations.add(pointAnnotation);
 
InputStream result = annotator.exportAnnotationsToDocument(cleanPdf, annotations, DocumentType.Pdf);
 
// Get metered value after usage of the annotation
double amountAfter = Metered.getConsumptionQuantity();
System.out.println("Amount consumed after: " + amountAfter);
System.out.println("Press any key...");
```
