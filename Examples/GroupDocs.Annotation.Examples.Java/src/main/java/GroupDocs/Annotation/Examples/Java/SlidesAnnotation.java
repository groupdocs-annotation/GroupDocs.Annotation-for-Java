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

public class SlidesAnnotation {
	
	// region initialize document name
	
	/*
	 * document name
	 */
	public static String fileName = "slide.pptx";
	
	// region Working with Annotations in Slides

	/*
	 * add annotation in Slides
	 */
	public static void addAnnotationInSlides() {
		//ExStart:addAnnotationInSlides
		try {
			AnnotationConfig cfg = Utilities.getConfiguration();
			AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
			InputStream inputStream = new FileInputStream(Utilities.storagePath + File.separator + fileName);
			List<AnnotationInfo> annotations = new ArrayList<AnnotationInfo>();
			final AnnotationInfo annotationInfo = new AnnotationInfo();
			annotationInfo.setPageNumber(0);
			annotationInfo.setAnnotationPosition(new Point(1, 2));
			annotationInfo.setFieldText("Hello!");
			annotationInfo.setCreatorName("John");
			annotations.add(annotationInfo);
			// Export annotations to Slides document
			InputStream resultStream = annotator.exportAnnotationsToDocument(inputStream, annotations);
			System.out.println(resultStream.available());
			IOUtils.copy(resultStream,
					new FileOutputStream(Utilities.outputPath + File.separator + "slides-annotated.pptx"));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		//ExEnd:addAnnotationInSlides
	}
}
