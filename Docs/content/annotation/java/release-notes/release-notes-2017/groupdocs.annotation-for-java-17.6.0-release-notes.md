---
id: groupdocs-annotation-for-java-17-6-0-release-notes
url: annotation/java/groupdocs-annotation-for-java-17-6-0-release-notes
title: GroupDocs.Annotation for Java 17.6.0 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Annotation for Java 17.6.0{{< /alert >}}

## Major Features 

Below the list of  new features and fixed bugs in this regular monthly release of GroupDocs.Annotation for Java. The most notable are:

*   Added support of annotation Diagrams documents (vsd, vss)
    1.  Arrow annotation
    2.  Area annotation
    3.  ResourceRedaction annotation
    4.  Polyline annotation
    5.  TextField annotation
*   Implement proper error handling when user try to invoke GetDocumentInfo method for images documents
*   Updated and improved library obfuscation

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| ANNOTATIONNET-417 | Implement Polyline annotation with Diagram documents | New Feature |
| ANNOTATIONNET-416 | Implement Arrow annotation for Diagram documents | New Feature |
| ANNOTATIONNET-410 | Implement Area annotation for Diagrams | New Feature |
| ANNOTATIONNET-406 | Add option to process CAD documents as PDF | Improvement |
| ANNOTATIONNET-405 | Implement GetPages method for Email documents processing from streams | Improvement |
| ANNOTATIONNET-401 | Implement proper error handling when user try to invoke GetDocumentInfo method for images documents | Improvement |
| ANNOTATIONNET-395 | Internal Exception in annotator.GetDocumentInfo() Method | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Annotation for Java 17.6.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Annotation which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Added annotating Diagrams (vss, vsd)  documents
