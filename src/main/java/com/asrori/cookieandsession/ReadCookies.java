package com.asrori.cookieandsession;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;

        // Get an array of Cookies associated with this domain
        cookies = req.getCookies();

        // Set response content type
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Membaca Cookie";
        String docType = "<!DOCTYPE html>\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" );

        if(cookies != null) {
            out.println("<h2> Nama Cookie dan Nilai</h2>");

            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print("Nama : " + cookie.getName() + ",  ");
                out.print("Nilai : " + cookie.getValue() + " <br/>");
            }
        } else {
            out.println("<h2>Cookies tidak ditemukan</h2>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
