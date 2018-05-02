package GroupDocs.Annotation.Examples.Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.groupdocs.annotation.common.license.License;
import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.DocumentType;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.RowData;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.domain.containers.DocumentInfoContainer;
import com.groupdocs.annotation.domain.image.PageImage;
import com.groupdocs.annotation.domain.options.ImageOptions;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.annotation.handler.input.IDocumentDataHandler;

public class Utilities {
	// ExStart:commonutilities
	public final static String storagePath = "./Data/SourceFiles/";
	public final static String outputPath = "./Data/OutputFiles/";
	public static final String licensePath = "E://GroupDocs.Total.Java.lic";
	// ExEnd::commonutilities
	// Applies License
	public static void applyLicenseFromFile() {
		//ExStart:applyLicenseFromFile
		try {
			// Setup license
			License lic = new License();
			lic.setLicense(licensePath);
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		//ExEnd:applyLicenseFromFile
	}

	// Returns AnnotationConfig configurations
	public static AnnotationConfig getConfiguration() {
		//ExStart:getConfiguration
		try {
			// Setup annotation configuration
			AnnotationConfig conversionConfig = new AnnotationConfig();
			conversionConfig.setStoragePath(storagePath);
			return conversionConfig;
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
			return null;
		}
		//ExEnd:getConfiguration
	}

	// Gets Image Representation
	public static void getImageRepresentation(String fileName) {
		//ExStart:getImageRepresentation
		try {
			InputStream document = new FileInputStream(storagePath + File.separator + fileName);
			AnnotationConfig cfg = getConfiguration();
			AnnotationImageHandler annotationHandler = new AnnotationImageHandler(cfg);
			List<PageImage> images = annotationHandler.getPages(document, new ImageOptions());
			// Save result stream to file.
			OutputStream outputStream = new FileOutputStream(Utilities.outputPath + File.separator + "image.png");
			final PageImage pageImage = images.get(0);
			IOUtils.copy(pageImage.getStream(), outputStream);
			System.out.println("Document exported!");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:getImageRepresentation
	}

	// Get text coordinates
	public static void getTextCoordinates(String fileName) {
		//ExStart:getTextCoordinates
		try {
			AnnotationConfig cfg = getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			DocumentInfoContainer documentInfoContainer = annotator.getDocumentInfo(fileName);
			// Go through all pages
			for (PageData pageData : documentInfoContainer.getPages()) {
				System.out.println("Page number: " + pageData.getNumber());
				// Go through all page rows
				for (int i = 0; i < pageData.getRows().size(); i++) {
					RowData rowData = pageData.getRows().get(i);
					// Write data to console
					System.out.println("Row: " + (i + 1));
					System.out.println("Text: " + rowData.getText());
					System.out.println("Text width: " + rowData.getLineWidth());
					System.out.println("Text height: " + rowData.getLineHeight());
					System.out.println("Distance from left: " + rowData.getLineLeft());
					System.out.println("Distance from top: " + rowData.getLineTop());
					// Get words
					String[] words = rowData.getText().split(" ");
					// Go through all word coordinates
					for (int j = 0; j < words.length; j++) {
						int coordinateIndex = j == 0 ? 0 : j + 1;
						// Write data to console
						System.out.println();
						System.out.println("Word:'" + words[j] + "'");
						System.out.println(
								"Word distance from left: " + rowData.getTextCoordinates().get(coordinateIndex));
						System.out.println("Word width: " + rowData.getTextCoordinates().get(coordinateIndex + 1));
						System.out.println();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:getTextCoordinates
	}

}
