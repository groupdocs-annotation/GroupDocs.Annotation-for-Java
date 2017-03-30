package com.groupdocs.ui.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.annotation.domain.containers.DocumentInfoContainer;
import com.groupdocs.annotation.handler.AnnotationImageHandler;
import com.groupdocs.ui.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/page/count")
public class PageCountServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AnnotationImageHandler handler = Utils.createAnnotationImageHandler();
        String filename = request.getParameter("file");
        DocumentInfoContainer info = handler.getDocumentInfo(filename);
        HashMap<String, Integer> result = new HashMap<>();
        result.put("count", info.getPages().size());
        response.setHeader("Content-Type", "application/json");
        new ObjectMapper().writeValue(response.getOutputStream(), result);
    }
}
