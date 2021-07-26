/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupdocs.ui.annotation.service;

import com.groupdocs.ui.annotation.entity.web.PageDataDescriptionEntity;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author AlexT
 */
public class StreamFactoryClass implements IPageStreamFactory {
    public List<PageDataDescriptionEntity> AnnotationPageDescriptionEntityList = new ArrayList<>();
    
    @Override
    public OutputStream createPageStream(int pageNumber) {
        //ByteArrayInputStream;
        //ByteArrayOutputStream;
        //return new MemoryStream();
        return new ByteArrayOutputStream();
    }
    
    @Override
    public void closePageStream(int pageNumber, InputStream pageStream) {
        try {
            PageDataDescriptionEntity page = new PageDataDescriptionEntity();

            BufferedImage imBuff;
            try {
                imBuff = ImageIO.read(pageStream);
                page.setHeight(imBuff.getHeight());
                page.setWidth(imBuff.getWidth());
                page.setNumber(pageNumber);
            } catch (IOException ex) {
                throw new TotalGroupDocsException(ex);
            }
            page.setData(getStringFromStream(pageStream));
            AnnotationPageDescriptionEntityList.add(page);
            pageStream.close();
        } catch (Exception ex) {
            throw new TotalGroupDocsException(ex);
	}
    }
    
    public static String getStringFromStream(InputStream inputStream) throws IOException {
        return new String(IOUtils.toByteArray(inputStream), StandardCharsets.UTF_8);
//        byte[] bytes = null;
//        //try (MemoryStream memoryStream = new MemoryStream()) {
//        try (ByteArrayOutputStream memoryStream = new ByteArrayOutputStream()) {
//            memoryStream = IOUtils.toByteArray(inputStream);
//            inputStream.CopyTo(memoryStream);
//            bytes = memoryStream.toByteArray();
//        }
//        // encode ByteArray into String
//        return Convert.ToBase64String(bytes);
    }
}