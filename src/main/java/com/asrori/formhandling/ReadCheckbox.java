package com.asrori.formhandling;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadCheckbox extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Baca Checkbox";
        String docType = "<!DOCTYPE html>\n";

        out.println(docType +
                        "<html>\n" +
                            "<head><title>" + title + "</title></head>\n" +
                        "<body bgcolor = \"#f0f0f0\">\n" +
                            "<h1 align = \"center\">" + title + "</h1>\n" +
                            "<ul>\n" +
                                "<li><b>Matematika : </b>: " + req.getParameter("matematika") + "</li>\n" +
                                "<li><b>Fisika : </b>: " + req.getParameter("fisika") + "</li>\n" +
                                "<li><b>Kimia : </b>: " + req.getParameter("kimia") + "</li>\n" +
                            "</ul>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
