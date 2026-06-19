![GitHub](https://img.shields.io/github/license/groupdocs-annotation/GroupDocs.Annotation-for-Java)

# Java Library for Document Annotation

[GroupDocs.Annotation for Java](https://products.groupdocs.com/annotation/java) is a [Document Annotation API](https://products.groupdocs.com/annotation/java) that supports over 13 different annotation types for [over 50 document formats](https://docs.groupdocs.com/annotation/java/supported-document-formats/) with full control over annotation's appearance.

<p align="center">
  <a title="Download complete GroupDocs.Annotation for Java source code" href="https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/archive/master.zip">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

## Important: Demo Applications Only

The projects in the [Demos](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Demos) folder and the Docker images published as [`groupdocs/annotation`](https://hub.docker.com/r/groupdocs/annotation) are **sample applications** intended to demonstrate [GroupDocs.Annotation for Java](https://products.groupdocs.com/annotation/java) features.

They are **not** production-ready services and must **not** be exposed to the public internet without additional hardening.

Before using a demo in any shared or production-like environment:

- Run it on `localhost` or a trusted private network only
- Do not publish Docker containers directly to the internet without authentication, a reverse proxy, and network restrictions
- Treat file upload, browse, and download features as untrusted input — validate and sandbox file paths in your own integration
- Add authentication, authorization, rate limiting, and logging appropriate for your security requirements
- Keep GroupDocs.Annotation and all dependencies up to date

For production integrations, use the library ([Examples](Examples), [documentation](https://docs.groupdocs.com/annotation/java/)) and implement your own secure document storage and API layer instead of deploying these demos as-is.

Directory | Description
--------- | -----------
[Demos](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Demos)  | GroupDocs.Annotation for Java Dropwizard and Spring Demo projects. 
[Examples](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 

## Demos

All web demos run on `http://localhost:8080/annotation/` and provide document annotation with zoom, thumbnails, download/upload, and print support.

| Demo | Framework | Build | Library Version |
|------|-----------|-------|-----------------|
| [Spring](Demos/Spring) | Spring Boot 2.0 | `mvn clean spring-boot:run` | 25.6 |
| [Dropwizard](Demos/Dropwizard) | Dropwizard 1.3 | `mvn clean compile exec:java` | 25.6 |

## Docker

Pre-built Docker images are available on [Docker Hub](https://hub.docker.com/r/groupdocs/annotation).

```bash
docker pull groupdocs/annotation:latest
docker run -p 8080:8080 groupdocs/annotation:latest
```

**Security notice:** Docker images ship with demo defaults (e.g. upload and browse enabled, no authentication). Use them for local evaluation only. Do not expose port `8080` to untrusted networks without adding authentication, path validation, and other security controls required by your organization.

Available image tags follow the pattern `{version}-java-{jdk}-bullseye-{framework}`:

| Tag | JDK | Framework |
|-----|-----|-----------|
| `{ver}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{ver}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{ver}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |
| `{ver}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{ver}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{ver}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |

The `latest` tag points to the `openjdk18-bullseye-spring` variant.

The [Docker Hub repository overview](https://hub.docker.com/r/groupdocs/annotation) is generated from [`docs/docker-hub-overview.md`](docs/docker-hub-overview.md) when the [Publish Docker Images](.github/workflows/docker-publish.yml) workflow runs with **Push** enabled.

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
