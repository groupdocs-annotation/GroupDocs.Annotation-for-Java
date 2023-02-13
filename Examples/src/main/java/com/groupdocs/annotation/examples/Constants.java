package com.groupdocs.annotation.examples;

public class Constants {

    public static String PROJECT_PATH = System.getProperty("user.dir");

    public static final String LicensePath = "C:\\Conholdate.Total.Product.Family.lic";//GroupDocs.Total.Java.lic";
    public static final String SamplesPath = "\\Resources\\SampleFiles\\";
    public static final String OutputPath = "\\Resources\\Output\\";
    
    public static String INPUT = getSampleFilePath("input.pdf");
    public static String CLEAR = getSampleFilePath("clear.pdf");
    public static String ANNOTATED_BIG = getSampleFilePath("annotated_big.pdf");
    public static String ANNOTATED_WITH_REPLIES = getSampleFilePath("annotated_with_replies.pdf");
    public static String ANNOTATED_WITH_REPLIES_NEW = getSampleFilePath("annotated_with_replies_new.pdf");
    public static String ANNOTATED_AREA_REPLIES_5 = getSampleFilePath("annotated_area_replies_5.pdf");

    public static String INPUT_PROTECTED = getSampleFilePath("input_protected.pdf");
    public static String RESULT = getSampleFilePath("result.pdf");
    public static String ANNOTATED = getSampleFilePath("annotated.pdf");
    public static String ANNOTATED_IMPORT = getSampleFilePath("annotated_import.pdf");

    public static String INPUT_DOC = getSampleFilePath("sample.docx");

    private static String getSampleFilePath(String fileName) {
        return PROJECT_PATH + SamplesPath + fileName;
    }

    public static String getOutputFilePath(String fileName, String fileExtension) {
        return PROJECT_PATH + OutputPath + fileName + "." + fileExtension;
    }

    public static String getPagePreviewPathFormat(String fileNameFormat) {
        return PROJECT_PATH + OutputPath + fileNameFormat;
    }
}