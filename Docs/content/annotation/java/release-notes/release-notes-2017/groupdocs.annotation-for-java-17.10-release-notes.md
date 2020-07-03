---
id: groupdocs-annotation-for-java-17-10-release-notes
url: annotation/java/groupdocs-annotation-for-java-17-10-release-notes
title: GroupDocs.Annotation for Java 17.10 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Annotation for Java 17.10{{< /alert >}}

## Major Features

Below the list of  new features and fixed bugs in this regular monthly release of GroupDocs.Annotation for Java. The most notable are:

*   Fixed SVG path parsing for specific cases
*   Implemented annotations import for Diagrams format (Area Redaction, Polyline, Text Field, Area Redaction)
*   Implemented setting opacity to annotations where it is possible
*   Exceptions handling improvements (added several more specific type of exceptions)
*   Implemented distance annotation adding for slides 
*   Implemented text annotations for Slides 
*   Added opacity for text annotations for Words 
*   Import text annotations for slides 
*   Fixed number of bugs from customers
*   Implemented export distance annotations for Words
*   Implemented adding comments for different types of Annotations for Diagrams format
*   Fixed wrong exporting comments for Words
*   Fixed issue with export large forn text for Wiords documents
*   Fixed comments exporting (in some cases old comments was exported)

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| ANNOTATIONNET-448 | Set opacity for Diagrams annotations | New Feature |
| ANNOTATIONNET-447 | Set opacity for Pdf annotations | New Feature |
| ANNOTATIONNET-446 | Set opacity for Words annotations | New Feature |
| ANNOTATIONNET-445 | Set opacity for Slides annotations | New Feature |
| ANNOTATIONNET-490 | Implement clean of distance annotation | New Feature |
| ANNOTATIONNET-441 | Import text field annotation from Diagram | New Feature |
| ANNOTATIONNET-440 | Import polyline annotation from Diagram | New Feature |
| ANNOTATIONNET-439 | Import Area Redaction annotation from diagram | New Feature |
| ANNOTATIONNET-438 | Import area annotation from diagram | New Feature |
| ANNOTATIONNET-430 | Implement import annotations for Diagram | New Feature |
| ANNOTATIONNET-419 | Implement TextField annotation for Diagrams | New Feature |
| ANNOTATIONNET-489 |  Implement export of distance annotation |  New Feature |
| ANNOTATIONNET-488 | Implement import of distance annotation | New Feature |
| ANNOTATIONNET-487 | Implement distance annotation for slides | New Feature |
| ANNOTATIONNET-482 | Import highlight annotation from slides | New Feature |
| ANNOTATIONNET-481 | Import underline annotation from slides | New Feature |
| ANNOTATIONNET-480 | Import strikeout annotation from slides | New Feature |
| ANNOTATIONNET-479 | Import text annotations from slides | New Feature |
| ANNOTATIONNET-477 | Implement opacity for text annotations in Words | New Feature |
| ANNOTATIONNET-475 | Implement opacity for text annotations in slides | New Feature |
| ANNOTATIONNET-468 | Implement underline annotation for slides | New Feature |
| ANNOTATIONNET-467 | Implement strikeout annotation for slides | New Feature |
| ANNOTATIONNET-466 | Implement text annotations for Slides | New Feature |
| ANNOTATIONNET-508 | Implement export distance annotation for words | New Feature |
| ANNOTATIONNET-504 | Add comment for distance annotation in Diagrams | New Feature |
| ANNOTATIONNET-455 | Add comment for arrow annotation in Diagrams | New Feature |
| ANNOTATIONNET-454 | Add comment for resource redaction annotation in Diagrams | New Feature |
| ANNOTATIONNET-453 | Add comment for area annotation in Diagrams | New Feature |
| ANNOTATIONNET-452 | Add comment for polyline annotation in Diagrams | New Feature |
| ANNOTATIONNET-451 | Implement adding comments to annotations in diagram | New Feature |
| ANNOTATIONJAVA-1000 | Set annotations opacity | New Feature |
| ANNOTATIONNET-442 | Implement additional specific exceptions | Improvement |
| ANNOTATIONNET-485 | Simplify the cleaning of the document for the correct import of text annotations | Improvement |
| ANNOTATIONNET-471 | Change arrow shape for arrow annotation | Improvement |
| ANNOTATIONNET-421 | Bug with parsing specific SVG path | Bug |
| ANNOTATIONNET-483 | Exception thrown when deleting annotation with multiple replies | Bug |
| ANNOTATIONNET-473 | Export document to word creates multiple comments | Bug |
| ANNOTATIONNET-510 | Wrong comment exported to Word | Bug |
| ANNOTATIONNET-509 | Wrong Distance annotation exported to word | Bug |
| ANNOTATIONNET-505 | Words: Fix export annotations for large fonts | Bug |
| ANNOTATIONNET-503 | Exporting a Word document adds old comments | Bug |
| ANNOTATIONNET-497 | Comment is not exported in Word | Bug |
| ANNOTATIONJAVA-1027 | Exception is generated while annotating xlsx formatted document | Bug |
| ANNOTATIONJAVA-1028 | Exception is generated while annotating pptx formatted document | Bug |
| ANNOTATIONJAVA-1033 | Exception when get a document using file path as argument | Bug |
| ANNOTATIONJAVA-1034 | Failed to get added annotations | Bug |
| ANNOTATIONJAVA-1035 | Exception is thrown when certain method is called simultaneously | Bug |
| ANNOTATIONJAVA-1036 | Exception is thrown when retrieving area annotation from DOCX file | Bug |
| ANNOTATIONJAVA-1037 | API fails to create Temp Directory in storage path | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Annotation for Java 17.10. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Annotation which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

To *AnnotationInfo* object added new *Opacity* field that sets opacity of annotation (can be null or float number between 0 and 1)



```java
public void setOpacity(Double value);
public Double getOpacity();
```

Sample of usage



```java
AnnotationInfo textAnnotation = new AnnotationInfo();
textAnnotation.setBox(new Rectangle(68, 154, 102, 9));
textAnnotation.setPageNumber(0);
textAnnotation.setSvgPath("[{\"x\":68.7886,\"y\":687.5769},{\"x\":170.8186,\"y\":687.5769},{\"x\":68.7886,\"y\":678.5769},{\"x\":170.8186,\"y\":678.5769}]");
textAnnotation.setType(AnnotationType.Text);
textAnnotation.setCreatorName("Anonym A.");
textAnnotation.setOpacity(0.1);
```

Import annotations from Diagram documents



```java
AnnotationConfig cfg = new AnnotationConfig();
cfg.setStoragePath(Utilities.STORAGE_PATH);
 
AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
 
if(!new File(cfg.getStoragePath()).exists() && !new File(cfg.getStoragePath()).mkdirs()) {
    System.out.println("Can't create directory!");
}
     
License license = new License();
license.setLicense(Utilities.LICENSE_PATH);
 
InputStream input = new FileInputStream(Utilities.STORAGE_PATH + File.separator + "testImportArrow.vsdx");
AnnotationInfo[] annotations = annotator.importAnnotations(input, DocumentType.Diagram);
 
InputStream clearDocument = new FileInputStream(Utilities.STORAGE_PATH + File.separator + "testClear.vsd");
InputStream output = annotator.exportAnnotationsToDocument(clearDocument, Arrays.asList(annotations), DocumentType.Diagram);
 
try (OutputStream fileStream = new FileOutputStream(Utilities.STORAGE_PATH + File.separator + "testDiagramExported.vsdx")) {
    IOUtils.copy(output, fileStream);
}
```
