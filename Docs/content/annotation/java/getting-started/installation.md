---
id: installation
url: annotation/java/installation
title: Installation
weight: 4
description: ""
keywords: 
productName: GroupDocs.Annotation for Java
hideChildren: False
---
GroupDocs hosts all Java APIs on [GroupDocs Repository](https://repository.groupdocs.com/). You can easily use [GroupDocs.Annotation for Java](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-annotation) API directly in your Maven projects with simple configurations.

### Specify GroupDocs Repository Configuration

First, you need to specify GroupDocs repository configuration/location in your Maven `pom.xml` as follows: 

```java
<repositories>
	<repository>
		<id>GroupDocsJavaAPI</id>
		<name>GroupDocs Java API</name>
		<url>http://repository.groupdocs.com/repo/</url>
	</repository>
</repositories>
```

### Define GroupDocs.Annotation for Java API Dependency

Then define GroupDocs.Annotation for Java API dependency in your `pom.xml` as follows:

```java
<dependencies>
    <dependency>
        <groupId>com.groupdocs</groupId>
        <artifactId>groupdocs-annotation</artifactId>
        <version>19.11</version> 
    </dependency>
</dependencies>
```

  
After performing above-mentioned steps, GroupDocs.Annotation for Java dependency will finally be added to your Maven project

## Install from official GroupDocs website

You can follow the steps below to reference GroupDocs.Annotation for Java downloaded from official website [Downloads section](https://downloads.groupdocs.com/annotation/java):

1.  Unpack zip archive.
2.  Switch to **lib** folder.
3.  Run **install.bat** (for Windows) or **install.sh** (for Linux) file to install the library in your local maven repository.
4.  After this you should add the GroupDocs.Annotation for Java **dependency** block to your pom.xml project file.
