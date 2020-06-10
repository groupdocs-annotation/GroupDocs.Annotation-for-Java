---
id: groupdocs-annotation-for-java-18-4-release-notes
url: annotation/java/groupdocs-annotation-for-java-18-4-release-notes
title: GroupDocs.Annotation for Java 18.4 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Annotation for Java 18.4{{< /alert >}}

## Major Features

Below is the list of new features improvements and fixes in this release of GroupDocs.Annotation for Java 18.4:

*   Added ability to import distance annotations in Words format
*   Improve import of annotations for Words format
*   Fixed several bugs regarding to PDF annotation import
*   Fixed TextField annotations import for Diagrams format
*   Fixed export some types of annotation for Diagrams format
*   Improved Replacement annotation for text in different paragraphs
*   Fixed import text field for Diagram documents
*   Fixed bug with import text annotations from Pdf
*   Fixed resizing image when user pass width and height
*   Fixed creating of Arrow annotation for Diagrams
*   Fixed issue with wrong distance structure after export in diagram
*   Fixed issue with wrong Polyline structure after export in diagram
*   Fixed bug with hanging of sample while importing distance annotation for Slides format
*   Fixed bug when importing area annotation
*   Fixed bug with importing annotations for diagrams
*   Improved export of underline text annotation for PDF
*   Improved export strikeout text annotation for PDF
*   Improved  creating annotations from colored or transparent text
*   Fixed transparent text for all formats
*   Fixed bug when importing text for TextField annotation in Diagrams

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| ANNOTATIONNET-563 | Implement import of distance annotation for Words document | New Feature |
| ANNOTATIONNET-583 | Add text redaction annotation in Slides document | New Feature |
| ANNOTATIONNET-560 | Merge similar annotations when importing from a MSWord document | Improvement |
| ANNOTATIONNET-559 | Improve import of text annotations for Words document | Improvement |
| ANNOTATIONNET-548 | Merge similar annotations when importing from a MSWord document | Improvement |
| ANNOTATIONNET-546 | Improve replacement annotation for text in different paragraphs | Improvement |
| ANNOTATIONNET-582 | Add point with text for text annotation | Improvement |
| ANNOTATIONNET-573 | Improve export of text annotations in Slides document | Improvement |
| ANNOTATIONNET-570 | Improve annotation export for big font sizes for Slides document | Improvement |
| ANNOTATIONNET-606 | Implement accepting SVG path also with spaces not only with commas | Improvement |
| ANNOTATIONNET-602 | Improve CleanUp for diagram | Improvement |
| ANNOTATIONNET-545 | Bug with import and export distance annotations in Pdf | Bug |
| ANNOTATIONNET-544 | Bug with import text annotations from Pdf | Bug |
| ANNOTATIONNET-543 | Bug with import arrow annotation from Pdf | Bug |
| ANNOTATIONNET-538 | AnnotationImageHandler.getPages does not respect ImageOptions.setWidth | Bug |
| ANNOTATIONNET-561 | Errors in import of diagrams: Wrong text in TextField annotation. | Bug |
| ANNOTATIONNET-556 | Fix import of arrow annotation in MSWord | Bug |
| ANNOTATIONNET-551 | Wrong Polyline structure after export in diagram | Bug |
| ANNOTATIONNET-550 | Errors in import of diagrams: Wrong text in TextField annotation. | Bug |
| ANNOTATIONNET-549 | Wrong distance structure after export in diagram | Bug |
| ANNOTATIONNET-547 | Wrong coordinates of annotations after exporting images | Bug |
| ANNOTATIONNET-591 | Fix Point annotation in Slides | Bug |
| ANNOTATIONNET-589 | Fix opacity value for import in Diagrams | Bug |
| ANNOTATIONNET-584 | Bug with import text field for diagram. | Bug |
| ANNOTATIONNET-581 | Arrow annotation doesn't create for diagrams. | Bug |
| ANNOTATIONNET-578 | Fix Slides bug with coordinates of paragraph and portion | Bug |
| ANNOTATIONNET-577 | Words:Fixed cleanup for text redaction annotation. | Bug |
| ANNOTATIONNET-574 | Bug with import text annotations from Pdf | Bug |
| ANNOTATIONNET-572 | Wrong distance structure after export in diagram | Bug |
| ANNOTATIONNET-571 | Wrong Polyline structure after export in diagram | Bug |
| ANNOTATIONNET-612 | Fix transparent color for lines of underline and strikeout annotations for Images | Bug |
| ANNOTATIONNET-611 | Fix transparent colors in Words document | Bug |
| ANNOTATIONNET-609 | Underline style of annotation doesn't set on text in Words document | Bug |
| ANNOTATIONNET-608 | Annotation of underline doesn't set in table in Words document | Bug |
| ANNOTATIONNET-607 | Export adds extra comment for every shape in diagrams | Bug |
| ANNOTATIONNET-605 | The align of text for TextField of annotation is wrong in Words document | Bug |
| ANNOTATIONNET-603 | Bug after export strikeout annotation in Words document | Bug |
| ANNOTATIONNET-601 | Bug when importing text for TextField annotation in diagrams | Bug |
| ANNOTATIONNET-598 | Imported from word document resource redaction annotation does not have color | Bug |
| ANNOTATIONNET-597 | Bug when importing area annotation from Words document | Bug |
| ANNOTATIONNET-596 | Bug with importing annotations for diagrams | Bug |
| ANNOTATIONNET-595 | The sample hangs while importing distance annotation for slides. | Bug |
| ANNOTATIONJAVA-697 | Aspose.PDF 10.6.2: Underline property does not work in text replace functional (Incorrect removing of underline text via Strikeout annotation) | Bug |
| ANNOTATIONJAVA-1064 | Annotation comments are not included in exported document | Bug |
| ANNOTATIONJAVA-1068 | Annotation comments are not imported from existing annotated document | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Annotation for Java 18.4. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Annotation which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  None
