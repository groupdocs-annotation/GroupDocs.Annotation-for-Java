package com.groupdocs.ui.servlet;

import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.annotation.handler.input.dataobjects.Document;
import com.groupdocs.ui.Utils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@WebServlet("/download/annotated")
public class DownloadAnnotatedServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        String filename = request.getParameter("file");

        Document document = Utils.findDocumentByName(filename);

        List<AnnotationInfo> list = Arrays.asList(imageHandler.getAnnotations(document.getId()).getAnnotations());

        InputStream exported;
        try (InputStream original = new FileInputStream(Utils.getStoragePath() + "/" + filename)) {
            exported = imageHandler.exportAnnotationsToDocument(original, list, document.getDocumentType());
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        IOUtils.copy(exported, response.getOutputStream());
    }
}
