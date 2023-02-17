![GitHub](https://img.shields.io/github/license/groupdocs-annotation/GroupDocs.Annotation-for-Java)

# Java Library for Document Annotation

GroupDocs.Annotation for Java is a [Document Annotation API](https://products.groupdocs.com/annotation/java) that supports over 13 different annotation types for [over 50 document formats](https://docs.groupdocs.com/annotation/java/supported-document-formats/) with full control over annotation's appearance.

<p align="center">
  <a title="Download complete GroupDocs.Annotation for Java source code" href="https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/archive/master.zip">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

Directory | Description
--------- | -----------
[Demos](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Demos)  | GroupDocs.Annotation for Java Dropwizard and Spring Demo projects. 
[Examples](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 

## Annotate Documents via Java

- Add, extract, update or remove annotations. 
- Import existing annotations from documents.
- Add or remove comments.
- Export annotated documents.
- [Generate document previews & thumbnails](https://docs.groupdocs.com/annotation/java/generate-document-pages-preview/).
- Load password-protected documents.
- Save annotated pages or pages by range.

## Annotation Objects

**Graphic Annotation:** Area, Arrow, Distance, Ellipse, Point, Polyline, Resource Redaction, TextField \
**Text Annotation:** Highlight, Link, Replacement, Strikeout, Reduction, Underline \
**Watermark:** Diagonal, Horizontal

## Get Started with GroupDocs.Annotation for Java

GroupDocs.Annotation for Java requires J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already.

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-annotation), so simply [configure](https://docs.groupdocs.com/annotation/java/installation/) your Maven project to fetch the dependencies automatically.

## Add Arrow Annotation

```java
    try(final Annotator annotator = new Annotator(Constants.INPUT_DOC)){
        String outputPath = Constants.getOutputFilePath("MinimalAnnotation", FilenameUtils.getExtension(Constants.INPUT_DOC));
        final ArrowAnnotation arrowAnnotation = new ArrowAnnotation();
        arrowAnnotation.setBox(new Rectangle(100, 100, 200, 200));
        annotator.add(arrowAnnotation);
        annotator.save(outputPath);
    }  
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/annotation/java) | [Documentation](https://docs.groupdocs.com/annotation/java/) | [Demos](https://products.groupdocs.app/annotation/family) | [API Reference](https://apireference.groupdocs.com/java/annotation) | [Examples](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/annotation/) | [Search](https://search.groupdocs.com/) | [Free Support](https://forum.groupdocs.com/c/annotation) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
