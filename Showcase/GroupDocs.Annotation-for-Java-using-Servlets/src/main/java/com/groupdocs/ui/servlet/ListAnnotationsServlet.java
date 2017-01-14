package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.AnnotationInfo;
import com.groupdocs.annotation.domain.results.GetAnnotationResult;
import com.groupdocs.annotation.domain.results.ListAnnotationsResult;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.annotation.handler.input.dataobjects.Document;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/annotation/list")
public class ListAnnotationsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        String filename = request.getParameter("file");

        Document doc = Utils.findDocumentByName(filename);
        ListAnnotationsResult listResult = imageHandler.getAnnotations(doc.getId());

        ArrayList<GetAnnotationResult> list = new ArrayList<>();
        for (AnnotationInfo inf : listResult.getAnnotations()) {
            list.add(imageHandler.getAnnotation(inf.getGuid()));
        }

        new ObjectMapper().writeValue(response.getOutputStream(), list);
    }
}
