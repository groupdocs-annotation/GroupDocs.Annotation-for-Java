package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.PageData;
import com.groupdocs.annotation.domain.RowData;
import com.groupdocs.annotation.domain.containers.DocumentInfoContainer;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/document/info")
public class DocumentInfoServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AnnotationImageHandler handler = Utils.createAnnotationImageHandler();
        String filename = request.getParameter("file");
        DocumentInfoContainer result = handler.getDocumentInfo(filename);
        response.setHeader("Content-Type", "application/json");
        new ObjectMapper().writeValue(response.getOutputStream(), result);
    }
}
