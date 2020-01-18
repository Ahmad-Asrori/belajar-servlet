package com.asrori.formhandling;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormGETExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Menggunakan method GET untuk membaca form data";
        String docType = "<!DOCTYPE html>\n";

        out.println(docType +
                "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                    "<h1 align = \"center\">" + title + "</h1>\n" +
                    "<ul>\n" +
                        "<li><b>First Name</b>: " + req.getParameter("nama_depan") + "</li>\n" +
                        "<li><b>Last Name</b>: " + req.getParameter("nama_belakang") + "</li>\n" +
                    "</ul>\n" +
                "</body>\n" +
                "</html>"
        );
    }
}
