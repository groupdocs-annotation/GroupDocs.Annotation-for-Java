---
id: groupdocs-annotation-for-java-17-1-0-release-notes
url: annotation/java/groupdocs-annotation-for-java-17-1-0-release-notes
title: GroupDocs.Annotation for Java 17.1.0 Release Notes
weight: 6
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Annotation for Java 17.1.0{{< /alert >}}

## Major Features

Below the list of improvements fixes and new features in this regular monthly release of GroupDocs.Annotation for Java. The most notable are:

*   Implement annotations import from Word documents
*   Implement  auto-import annotations when opening PDF documents
*   Add native Word annotations after export to Word documents different types of annotations
*   Fix users permission for Delete annotations
*   Implemented following for slides documents:
*   Point annotation
*   Area annotation
*   ResourceRedaction annotation
*   Arrow annotation
*   TextField annotation
*   Polyline annotation
*   Watermark annotation
*   Show and store annotation author when export annotation for PDF documents

Implemented following for slides documents:

*   TextHighlight annotation
*   TextStrikeout annotation
*   TextUndreline annotation

Implemented ability to import following annotations:

*   Import of ResourceRedaction annotation
*   Import of Text Field annotation 
*   Import of Area annotation
*   Import of Arrow annotation
*   Import of Polyline annotation
*   Import of Watermark annotation
*   Import of Point annotation

Implemented following annotations for images:

*   Watermart annotation
*   Polyline annotation
*   Text Underline annotation
*   Text Strikeout annotation
*   TextField annotation
*   Point annotation
*   Resource Redaction annotation
*   Area annotation

Implemented annotating documents of following types:

*   JPG
*   TIFF
*   BMP
*   GIF (static images without animation)

Fixed following bugs:

*   When exporting Slide document TextField annotation hasn't text
*   For Slides format fix background when import Resource Redaction annotation 

Improvement:

*   Increase number of integration test for improving quality of product

Fixed bug with wrong annotation orientation (After export PDF annotations are shifted to other place)

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| ANNOTATIONNET-249 | Import TextField annotation from Words Documents | New Feature |
| ANNOTATIONNET-236 | Implement TextRedaction annotation import from Word | New Feature |
| ANNOTATIONNET-244 | Implement Shape annotations import from Word | New Feature |
| ANNOTATIONNET-237 | Implement TextStrikeout annotation import from Word | New Feature |
| ANNOTATIONNET-238 | Implement Underline annotation import from Word | New Feature |
| ANNOTATIONNET-235 | Implement Area annotation import from Word | New Feature |
| ANNOTATIONNET-234 | Implement Text annotation import from Word | New Feature |
| ANNOTATIONNET-230 | Add native Word annotations after export Word documents to Text Replacement annotation | New Feature |
| ANNOTATIONNET-224 | Add native Word annotations after export Word documents | New Feature |
| ANNOTATIONNET-228 | Add native Word annotations after export Word documents to Strikeout annotation | New Feature |
| ANNOTATIONNET-282 | Implement Watermark annotation for Slides format | New Feature |
| ANNOTATIONNET-276 | Implement Area annotation for Slides format | New Feature |
| ANNOTATIONNET-275 | Implement Arrow annotation for Slides format | New Feature |
| ANNOTATIONNET-273 | Implement Text Field annotation in Slides document | New Feature |
| ANNOTATIONNET-272 | Implement Polyline annotation for Slides format | New Feature |
| ANNOTATIONNET-271 | Implement Point annotation for Slides format | New Feature |
| ANNOTATIONNET-303 | Implement Strikeout annotation for Slides format | New Feature |
| ANNOTATIONNET-302 | Implement Undreline annotation for Slides format | New Feature |
| ANNOTATIONNET-301 | Implement Highlight annotation for Slides format | New Feature |
| ANNOTATIONNET-296 | Implement import of Text Field annotation for Slides | New Feature |
| ANNOTATIONNET-295 | Implement import of Point annotation for Slides | New Feature |
| ANNOTATIONNET-294 | Implement import of Resource Redaction annotation for Slides | New Feature |
| ANNOTATIONNET-293 | Implement import of Watermark annotation for Slides | New Feature |
| ANNOTATIONNET-292 | Implement import of Polyline annotation for Slides | New Feature |
| ANNOTATIONNET-291 | Implement import of Arrow annotation for Slides | New Feature |
| ANNOTATIONNET-290 | Implement import of Area annotation for Slides | New Feature |
| ANNOTATIONNET-320 | Implement Watermark annotation for images | New Feature |
| ANNOTATIONNET-319 | Implement Polyline annotation for images | New Feature |
| ANNOTATIONNET-318 | Implement Text Underline annotation for images | New Feature |
| ANNOTATIONNET-317 | Implement Text Strikeout annotations for images | New Feature |
| ANNOTATIONNET-316 | Implement TextField annotation for images | New Feature |
| ANNOTATIONNET-315 | Implement Point annotation for images | New Feature |
| ANNOTATIONNET-314 | Implement Resource Redaction annotation for images | New Feature |
| ANNOTATIONNET-313 | Implement Area annotation for images | New Feature |
| ANNOTATIONNET-337 | Implement annotating GIF format static images (without animation) | New Feature |
| ANNOTATIONNET-332 | Implement annotating TIFF format images | New Feature |
| ANNOTATIONNET-331 | Implement annotating BMP format images | New Feature |
| ANNOTATIONNET-329 | Implement annotating JPEG format images | New Feature |
| ANNOTATIONNET-241 | Implement option for ability to auto-import annotations when opening PDF documents | Improvement |
| ANNOTATIONNET-266 | Show and store annotation author when export annotation for PDF documents | Improvement |
| ANNOTATIONNET-250 | Fix users permission for Delete annotations | Bug |
| ANNOTATIONNET-298 | Arrow annotation imported incorrectly on several Words documents | Bug |
| ANNOTATIONNET-311 | Wrong annotation orientation (After export PDF annotations are shifted to other place) | Bug |
| ANNOTATIONNET-335 | While exporting Slide document TextField annotation hasn't text | Bug |
| ANNOTATIONNET-324 | Fix background when import Resource Redaction annotation (for slides) | Bug |
| ANNOTATIONJAVA-904 | Quality doesn't work | Bug |
| ANNOTATIONJAVA-915 | Search functionality doesn't work for one pdf | Bug |
| ANNOTATIONJAVA-856 | Incorrect rendering "strickeout text" annotation after import | Bug |
| ANNOTATIONJAVA-877 | Localization works only after a document was rendered | Bug |
| ANNOTATIONJAVA-907 | Access callbacks ExportPdf and ExportWord do not works | Bug |
| ANNOTATIONJAVA-911 | Performance issue with .pdf document that has a lot of images | Bug |
| ANNOTATIONJAVA-764 | Document comments reply issues | Bug |
| ANNOTATIONJAVA-910 | Issue with showing Excel groups | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Annotation for Java 17.1.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Annotation which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

  

Added ability to import annotations from Words documents: Documentation article

Added ability to annotate Slides documents with different annotations types: Documentation article

Added ability to import annotations from Slides documents: Documentation article

Added ability to add text annotations to Slides documents (TextHighlight, TextStrikeout, TextUnderline): Documentation article

Added ability to annotate images: Documentation article

Added new formats to annotating images article: Documentation article
