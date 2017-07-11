package GroupDocs.Annotation.Examples.Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.IOUtils;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.AnnotationType;
import com.groupdocs.annotation.domain.DocumentType;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.Rectangle;
import com.groupdocs.annotation.domain.RowData;
import com.groupdocs.annotation.domain.config.AnnotationConfig;
import com.groupdocs.annotation.domain.containers.DocumentInfoContainer;
import com.groupdocs.annotation.handler.AnnotationImageHandler;

public class ImagesAnnotation {
	//ExStart:ImagesAnnotation
	/*
	 * document name
	 */
	//From version 17.1.0 you can work with images of EMF/WMF, CAD-files (DWG), DICOM, DjVu, PNG, JPG, TIFF, BMP and GIF(static without animation) format images
	public static void differentAnnotationsForImages(String fileName) throws Throwable{
		AnnotationConfig cfg = Utilities.getConfiguration();
		AnnotationImageHandler annotator = new AnnotationImageHandler(cfg);
		
		FileInputStream cleanPresentation = new FileInputStream(Utilities.storagePath + File.separator + fileName);
		ArrayList<AnnotationInfo> annotations;
		annotations = new ArrayList<AnnotationInfo>();
		 
		AnnotationInfo textAnnotation = new AnnotationInfo();
		textAnnotation.setBox(new Rectangle(50, 510.9f, 454.73f, 29.08f));
		textAnnotation.setPageNumber(0);
		textAnnotation.setSvgPath("[{\"x\":200,\"y\":520.92},{\"x\":454.73,\"y\":520.92},{\"x\":200,\"y\":539.98},{\"x\":454.73,\"y\":539.98}]");
		textAnnotation.setType(AnnotationType.Text);
		textAnnotation.setCreatorName("Anonym A.");
		 
		AnnotationInfo textRedactionAnnotation = new AnnotationInfo();
		textRedactionAnnotation.setBox(new Rectangle(50, 510.9f, 454.73f, 29.08f));
		textRedactionAnnotation.setPageNumber(0);
		textRedactionAnnotation.setSvgPath("[{\"x\":200,\"y\":545.92},{\"x\":454.73,\"y\":545.92},{\"x\":200,\"y\":564.98},{\"x\":454.73,\"y\":564.98}]");
		textRedactionAnnotation.setType(AnnotationType.TextRedaction);
		textRedactionAnnotation.setCreatorName("Anonym A.");
		 
		AnnotationInfo strikeoutAnnotation = new AnnotationInfo();
		strikeoutAnnotation.setBox(new Rectangle(0, 510.92f, 454.73f, 29.08f));
		strikeoutAnnotation.setPageNumber(0);
		strikeoutAnnotation.setSvgPath("[{\"x\":120,\"y\":520.92},{\"x\":454.73,\"y\":520.92},{\"x\":120,\"y\":539.98},{\"x\":454.73,\"y\":539.98}]");
		strikeoutAnnotation.setType(AnnotationType.TextStrikeout);
		strikeoutAnnotation.setCreatorName("Anonym A.");
		     
		AnnotationInfo underlineAnnotation = new AnnotationInfo();
		underlineAnnotation.setBox(new Rectangle(0, 510.92f, 454.73f, 29.08f));
		underlineAnnotation.setPageNumber(0);
		underlineAnnotation.setSvgPath("[{\"x\":120,\"y\":520.92},{\"x\":454.73,\"y\":520.92},{\"x\":120,\"y\":539.98},{\"x\":454.73,\"y\":539.98}]");
		underlineAnnotation.setType(AnnotationType.TextUnderline);
		underlineAnnotation.setCreatorName("Anonym A.");
		     
		AnnotationInfo pointAnnotation = new AnnotationInfo();
		pointAnnotation.setPageNumber(0);
		pointAnnotation.setType(AnnotationType.Point);
		pointAnnotation.setBox(new Rectangle(100, 100, 0, 0));
		pointAnnotation.setFieldText("Hello!");
		pointAnnotation.setCreatorName("John");
		 
		AnnotationInfo areaAnnotation = new AnnotationInfo();
		areaAnnotation.setCreatedOn(new Date());
		areaAnnotation.setType(AnnotationType.Area);
		areaAnnotation.setPageNumber(0);
		areaAnnotation.setBox(new Rectangle(200, 72.7f, 50, 50));
		areaAnnotation.setBackgroundColor(-15988609);
		 
		AnnotationInfo polylineAnnotation = new AnnotationInfo();
		polylineAnnotation.setType(AnnotationType.Polyline);
		polylineAnnotation.setCreatedOn(new Date());
		polylineAnnotation.setBox(new Rectangle((float)250.82807922363281, (float)35.632957458496094, (float)102.70676422119141, (float)12.576337814331055));
		polylineAnnotation.setPageNumber(0);
		polylineAnnotation.setPenColor(65015);
		polylineAnnotation.setSvgPath(
		    "M250.8280751173709,48.209295774647885l0.6986854460093896,0l0.6986854460093896, -1.3973708920187793l0.6986854460093896,"
		    + "0l0.6986854460093896,-1.3973708920187793l1.3973708920187793, -0.6986854460093896l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0l2.096056338028169,"
		    + "-1.3973708920187793l3.493427230046948,-1.3973708920187793l0.6986854460093896,-0.6986854460093896l1.3973708920187793,"
		    + "-1.3973708920187793l0.6986854460093896,0l1.3973708920187793,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,"
		    + "-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,0l0,-0.6986854460093896l0.6986854460093896,0l0.6986854460093896,"
		    + "0l1.3973708920187793,0l0,-0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,"
		    + "0l0.6986854460093896,0l2.096056338028169,-0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,"
		    + "0l1.3973708920187793,0l1.3973708920187793,0l1.3973708920187793,0l2.096056338028169,0l5.589483568075117,0l1.3973708920187793,"
		    + "0l2.096056338028169,0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l1.3973708920187793,0l1.3973708920187793,"
		    + "0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0l2.096056338028169,1.3973708920187793l0.6986854460093896,0l0.6986854460093896,"
		    + "0l0,0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0.6986854460093896l1.3973708920187793,0.6986854460093896l0,"
		    + "0.6986854460093896l0.6986854460093896,0l1.3973708920187793,0.6986854460093896l1.3973708920187793,0.6986854460093896l3.493427230046948,"
		    + "0.6986854460093896l1.3973708920187793,0.6986854460093896l2.096056338028169,0.6986854460093896l1.3973708920187793,"
		    + "0.6986854460093896l1.3973708920187793,0l1.3973708920187793,0.6986854460093896l0.6986854460093896,0l0.6986854460093896,"
		    + "0.6986854460093896l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,"
		    + "0l0.6986854460093896,0l1.3973708920187793,0l0.6986854460093896,0l0.6986854460093896,0l1.3973708920187793,"
		    + "0l0.6986854460093896,0l2.7947417840375586,0l0.6986854460093896,0l2.7947417840375586,0l1.3973708920187793,"
		    + "0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,0l0.6986854460093896,"
		    + "0l0.6986854460093896,0l0.6986854460093896,-0.6986854460093896l0.6986854460093896,0"
		);
		 
		AnnotationInfo resourceRedactionAnnotation = new AnnotationInfo();
		resourceRedactionAnnotation.setCreatedOn(new Date());
		resourceRedactionAnnotation.setType(AnnotationType.ResourcesRedaction);
		resourceRedactionAnnotation.setPageNumber(0);
		resourceRedactionAnnotation.setBox(new Rectangle(100, 72.7f, 50, 50));
		 
		AnnotationInfo textFieldAnnotation = new AnnotationInfo();
		textFieldAnnotation.setCreatedOn(new Date());
		textFieldAnnotation.setType(AnnotationType.TextField);
		textFieldAnnotation.setPageNumber(0);
		textFieldAnnotation.setBox(new Rectangle(100, 72.7f, 50, 50));
		textFieldAnnotation.setFontColor(-15988609);
		textFieldAnnotation.setFieldText("some text");
		textFieldAnnotation.setFontFamily("times new roman");
		 
		AnnotationInfo watermarkAnnotation = new AnnotationInfo();
		watermarkAnnotation.setCreatedOn(new Date());
		watermarkAnnotation.setType(AnnotationType.Watermark);
		watermarkAnnotation.setFieldText("This is watermark");
		watermarkAnnotation.setFontFamily("arial");
		watermarkAnnotation.setBox(new Rectangle(200, 250, 50, 0));
		watermarkAnnotation.setFontSize(25);
		watermarkAnnotation.setFontColor(15988609);
		 
		AnnotationInfo distanceAnnotation = new AnnotationInfo();
		distanceAnnotation.setCreatedOn(new Date());
		distanceAnnotation.setType(AnnotationType.Distance);
		distanceAnnotation.setBox(new Rectangle(20, 20, 250, 250));
		distanceAnnotation.setBackgroundColor(-15988609);
		distanceAnnotation.setText("500px");
		distanceAnnotation.setFontFamily("Arial");
		 
		AnnotationInfo arrowAnnotation = new AnnotationInfo();
		arrowAnnotation.setCreatedOn(new Date());
		arrowAnnotation.setType(AnnotationType.Arrow);
		arrowAnnotation.setBox(new Rectangle(250, 72.7f, 0, 20));
		arrowAnnotation.setBackgroundColor(-15988609);
		     
		annotations.add(textAnnotation);
		annotations.add(pointAnnotation);
		annotations.add(areaAnnotation);
		annotations.add(textRedactionAnnotation);
		annotations.add(resourceRedactionAnnotation);
		annotations.add(polylineAnnotation);
		annotations.add(watermarkAnnotation);
		annotations.add(textFieldAnnotation);
		annotations.add(strikeoutAnnotation);
		annotations.add(underlineAnnotation);
		annotations.add(distanceAnnotation);
		annotations.add(arrowAnnotation);
		 
		InputStream result = annotator.exportAnnotationsToDocument(cleanPresentation, annotations, DocumentType.Images);
		 
		try (OutputStream fileStream = new FileOutputStream(Utilities.outputPath + File.separator + "Image-annotated.png")){
		    System.out.println(result.available());
		    IOUtils.copy(result, fileStream);
		}
		//ExEnd:ImagesAnnotation
	}

}
