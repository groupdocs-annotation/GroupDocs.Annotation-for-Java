package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.results.ListAnnotationsResult;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.annotation.handler.input.IDocumentDataHandler;
import com.groupdocs.annotation.handler.input.dataobjects.Document;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annotation/list")
public class ListAnnotationsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        AnnotationImageHandler imageHandler = Utils.createAnnotationImageHandler();
        String filename = request.getParameter("file");

        Document doc = Utils.findDocumentByName(filename);
        ListAnnotationsResult list = imageHandler.getAnnotations(doc.getId());
        new ObjectMapper().writeValue(response.getOutputStream(), list.getAnnotations());
    }
}
