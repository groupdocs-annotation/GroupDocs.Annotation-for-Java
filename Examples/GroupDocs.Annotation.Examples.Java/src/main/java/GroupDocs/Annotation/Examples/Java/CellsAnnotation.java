
package GroupDocs.Annotation.Examples.Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.Point;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.handler.AnnotationImageHandler;

public class CellsAnnotation {
	
	// region initialize document name
			
	/*
	 * document name
	 */
	
	public static String fileName = "excel.xlsx";
	
	// region Working with Annotations in Cells

	/*
	 * add annotation in Cells
	 */
	
	public static void addAnnotationInCells() {
		//ExStart:addAnnotationInCells
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream inputStream = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			// Add bookmark to 3rd cell in 3rd row on 1st page
			final AnnotationInfo annotationInfo = new AnnotationInfo();
			annotationInfo.setPageNumber(1);
			annotationInfo.setAnnotationPosition(new Point(3, 3));
			annotationInfo.setFieldText("Hello!");
			annotations.add(annotationInfo);
			// Export annotations to Cells document
			InputStream resultStream = annotator.exportAnnotationsToDocument(inputStream, annotations);
			System.out.println(resultStream.available());
			IOUtils.copy(resultStream,
					new FileOutputStream(Utilities.outputPath + File.separator + "cells-annotated.xlsx"));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addAnnotationInCells
	}
}
