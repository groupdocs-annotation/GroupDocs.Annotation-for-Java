![GitHub release (latest by date)](https://img.shields.io/github/v/release/groupdocs-annotation/GroupDocs.Annotation-for-Java) ![GitHub all releases](https://img.shields.io/github/downloads/groupdocs-annotation/GroupDocs.Annotation-for-Java/total) ![GitHub](https://img.shields.io/github/license/groupdocs-annotation/GroupDocs.Annotation-for-Java)

# Java Library for Document Annotation

GroupDocs.Annotation for Java is a [Document Annotation API](https://products.groupdocs.com/annotation/java) that supports over 13 different annotation types for [over 50 document formats](https://docs.groupdocs.com/annotation/java/supported-document-formats/) with full control over annotation's appearance.

<p align="center">
  <a title="Download complete GroupDocs.Annotation for Java source code" href="https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/archive/master.zip">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

Directory | Description
--------- | -----------
[Examples](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 
[Demos](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Demos)  | GroupDocs.Annotation for Java Dropwizard and Spring Demo projects. 

## Annotate Documents via Java

- Add, extract, update or remove annotations. 
- Import existing annotations from documents.
- Add or remove comments.
- Export annotated documents.
- [Generate document previews & thumbnails](https://docs.groupdocs.com/annotation/java/generate-document-pages-preview/).
- Load password protected documents.
- Save annotated pages or pages by range.

## Annotation Objects

**Graphic Annotation:** Area, Arrow, Distance, Ellipse, Point, Polyline, Resource Redaction, TextField \
**Text Annotation:** Highlight, Link, Replacement, Strikeout, Reduction, Underline \
**Watermark:** Diagonal, Horizontal

## Get Started with GroupDocs.Annotation for Java

GroupDocs.Annotation for Java requires J2SE 7.0 (1.7), J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already.

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-annotation), so simply [configure](https://docs.groupdocs.com/annotation/java/installation/) your Maven project to fetch the dependencies automatically.

## Add Watermark Annotation

```java
String outputPath = Constants.getOutputFilePath("AddWatermarkAnnotation", FilenameUtils.getExtension(Constants.INPUT));
final Annotator annotator = new Annotator(Constants.INPUT);
try {
	Reply reply1 = new Reply();
	reply1.setComment("First comment");
	reply1.setRepliedOn(Calendar.getInstance().getTime());
	Reply reply2 = new Reply();
	reply2.setComment("Second comment");
	reply2.setRepliedOn(Calendar.getInstance().getTime());
	java.util.List<Reply> replies =  new ArrayList<Reply>();
	replies.add(reply1);
	replies.add(reply2);
	WatermarkAnnotation watermark = new WatermarkAnnotation();
	watermark.setAngle((double) 75);
	watermark.setBox(new Rectangle(200, 200, 100, 50));
	watermark.setCreatedOn(Calendar.getInstance().getTime());
	watermark.setText("Watermark");
	watermark.setFontColor(65535);
	watermark.setFontSize((double) 12);
	watermark.setMessage("This is watermark annotation");
	watermark.setOpacity(0.7);
	watermark.setPageNumber(0);
	watermark.setReplies(replies);
	annotator.add(watermark);
	annotator.save(outputPath);
} finally {
	if (annotator != null) {
		annotator.dispose();
	}
}
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/annotation/java) | [Documentation](https://docs.groupdocs.com/annotation/java/) | [Demos](https://products.groupdocs.app/annotation/family) | [API Reference](https://apireference.groupdocs.com/java/annotation) | [Examples](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/annotation/) | [Search](https://search.groupdocs.com/) | [Free Support](https://forum.groupdocs.com/c/annotation) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
