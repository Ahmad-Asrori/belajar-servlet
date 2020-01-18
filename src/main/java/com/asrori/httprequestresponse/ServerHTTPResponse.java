package com.asrori.httprequestresponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ServerHTTPResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set refresh, ngeload terus setiap 5 detik
        resp.setIntHeader("Refresh", 5);

        // Set response content type
        resp.setContentType("text/html");

        // untuk mendapatkan waktu yang sedang berjalan
        Calendar kalender = new GregorianCalendar();
        String am_pm;
        int jam = kalender.get(Calendar.HOUR);
        int menit = kalender.get(Calendar.MINUTE);
        int detik = kalender.get(Calendar.SECOND);

        if(kalender.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
        else
            am_pm = "PM";

        String CT = jam + ":" + menit + ":" + detik + " " + am_pm;

        PrintWriter out = resp.getWriter();
        String title = "Auto Refresh Header Setting";
        String docType = "<!DOCYTPE html>\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<p>Current Time is: " + CT + "</p>\n"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
