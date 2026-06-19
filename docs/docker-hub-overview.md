### GroupDocs Document Annotation API

[Product Page](https://products.groupdocs.com/annotation/java) | [Docs](https://docs.groupdocs.com/annotation/java/) | [Demos](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/annotation) | [Examples](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/annotation/) | [Free Support](https://forum.groupdocs.com/c/annotation) | [Temporary License](https://purchase.groupdocs.com/temporary-license)

**GroupDocs.Annotation Demos** are applications that demonstrate powerful features of [GroupDocs.Annotation for Java](https://products.groupdocs.com/annotation/java) distributed as Docker images. Annotate **DOCX, PDF, PPT, XLS**, and over 90 document formats without additional dependencies. Use these images as-is or customize and integrate them into your own project.

**Note:** without a license the application runs in trial mode. [Purchase a license](https://purchase.groupdocs.com/annotation/java) or request a [temporary license](https://purchase.groupdocs.com/temporary-license).

## Security Notice

These Docker images ship **sample/demo applications** — not production-ready services.

- Intended for **local development and evaluation** only
- Demo defaults enable upload, browse, and download; **no authentication** is included
- Do **not** expose port `8080` to untrusted networks without authentication, a reverse proxy, path validation, and other controls required by your organization
- For production, use the [GroupDocs.Annotation library](https://docs.groupdocs.com/annotation/java/) and implement your own secure document storage and API layer

Source code: [GroupDocs.Annotation-for-Java](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java)

## Supported Document Formats

GroupDocs.Annotation for Java supports [over 50 document formats](https://docs.groupdocs.com/annotation/java/supported-document-formats/) including Microsoft Office, PDF, images, CAD, and more.

## Document Annotation Demo Features

- Clean, modern and intuitive design
- Responsive design and mobile support
- Add, edit, and remove annotations
- Text, area, arrow, watermark, and other annotation types
- Download, upload, and print documents
- Zoom, thumbnails, and smooth navigation
- Cross-browser and cross-platform support

## Available Docker Images

Six images are published for each GroupDocs.Annotation for Java release: three Spring and three Dropwizard variants.

Tag format: `{version}-java-{jdk}-bullseye-{framework}`

Example: `{{VERSION}}-java-openjdk8-bullseye-dropwizard` — GroupDocs.Annotation for Java **{{VERSION}}**, Eclipse Temurin 8, Debian Bullseye, Dropwizard.

| Tag | JDK | Framework |
| --- | --- | --- |
| `{{VERSION}}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{{VERSION}}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{{VERSION}}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |
| `{{VERSION}}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{{VERSION}}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{{VERSION}}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |

The `latest` tag points to the `{{VERSION}}-java-openjdk18-bullseye-spring` variant when published with the **latest** workflow option.

## How to Run

Pull and run a Dropwizard image:

```shell
docker run -p 8080:8080 --name annotation --rm groupdocs/annotation:{{VERSION}}-java-openjdk8-bullseye-dropwizard
# Open http://localhost:8080/annotation/ in your browser.
```

Bind volumes for sample files and license:

```shell
docker run -p 8080:8080 --name annotation --rm \
  -v "C:/DocumentSamples/:/home/groupdocs/app/DocumentSamples" \
  -v "C:/Licenses/:/home/groupdocs/app/Licenses" \
  groupdocs/annotation:{{VERSION}}-java-openjdk8-bullseye-dropwizard
```

The sample reads license files from the mounted `Licenses` directory and lists documents from `DocumentSamples`.

## Annotation Configuration Options

Environment variables:

| Variable | Description | Default |
| --- | --- | --- |
| `LIC_PATH` | Path to directory with license file | `/home/groupdocs/app/Licenses` |
| `DOWNLOAD_ON` | Enable download button in UI | `true` |
| `UPLOAD_ON` | Enable file upload | `true` |
| `PRINT_ON` | Enable print | `true` |
| `BROWSE_ON` | Enable document browse dialog | `true` |
| `RIGHTCLICK_ON` | Enable right-click context menu | `true` |
| `FILES_DIR` | Directory for uploaded files | `/home/groupdocs/app/DocumentSamples` |
| `HOST_ADDRESS` | Host name or IP for the server instance | (empty) |

## See Also

- [View documents](https://products.groupdocs.com/viewer/java) with GroupDocs.Viewer
- [Compare documents](https://products.groupdocs.com/comparison/java) with GroupDocs.Comparison
- [Sign documents](https://products.groupdocs.com/signature/java) with GroupDocs.Signature

[Product Page](https://products.groupdocs.com/annotation/java) | [Docs](https://docs.groupdocs.com/annotation/java/) | [Demos](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/annotation) | [Examples](https://github.com/groupdocs-annotation/GroupDocs.Annotation-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/annotation/) | [Free Support](https://forum.groupdocs.com/c/annotation) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
