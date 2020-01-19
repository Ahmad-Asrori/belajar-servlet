package com.asrori.cookieandsession;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // buat cookies untuk nama depan dan nama belakang.
        Cookie namaDepan = new Cookie("nama_depan", req.getParameter("nama_depan"));
        Cookie namaBelakang = new Cookie("nama_belakang", req.getParameter("nama_belakang"));

        // atur masa expired kedua cookia (dalam hal ini diatur 24 jam)
        namaDepan.setMaxAge(60*60*24);
        namaBelakang.setMaxAge(60*60*24);

        // Add both the cookies in the response header.
        resp.addCookie(namaDepan);
        resp.addCookie(namaBelakang);

        // Set response content type
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Mengatur Cookie";
        String docType = "<!DOCTYPE html>\n";

        out.println(docType +
                "<html>\n" +
                "<head>\n"+
                    "<title>" + title + "</title>\n" +
                "</head>\n" +

                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                    "<li><b>First Name</b>: " + req.getParameter("nama_depan") + "\n" +
                    "<li><b>Last Name</b>: " + req.getParameter("nama_belakang") + "\n" +
                "</ul>\n" +
                "</body>\n" +
                "</html>\n"
      );
    }
}
