package com.asrori.cookieandsession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SessionTracking extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // buat objek session jika belum dibuat
        HttpSession session = req.getSession(true);

        // Get session creation time.
        Date createTime = new Date(session.getCreationTime());

        // Get last access time of this web page.
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        String title = "Selamat Datang Kembali Di website";
        Integer visitCount = 0;
        String visitCountKey = "visitCount";
        String userIDKey = "userID";
        String userID = "ABCD";

        // cek jika request yang masuk adalah request yang datang dari pengunjung baru
        if (session.isNew()) {
            title = "Selamat Datang Di Website";
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer)session.getAttribute(visitCountKey);
            visitCount = visitCount + 1;
            userID = (String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey,  visitCount);

        // Set response content type
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<h2 align = \"center\">Session Infomation</h2>\n" +
                "<table border = \"1\" align = \"center\">\n" +

                "<tr bgcolor = \"#949494\">\n" +
                "  <th>Session info</th><th>value</th>" +
                "</tr>\n" +

                "<tr>\n" +
                    "<td>id</td>\n" +
                    "<td>" + session.getId() + "</td>\n" +
                "</tr>\n" +

                "<tr>\n" +
                    "<td>Creation Time</td>\n" +
                    "<td>" + createTime + "</td>\n" +
                "</tr>\n" +

                "<tr>\n" +
                    "<td>Time of Last Access</td>\n" +
                    "<td>" + lastAccessTime + "</td>\n" +
                "</tr>\n" +

                "<tr>\n" +
                    "<td>User ID</td>\n" +
                "  <td>" + userID + "</td>" +
                "</tr>\n" +

                "<tr>\n" +
                    "<td>Number of visits</td>\n" +
                    "<td>" + visitCount + "</td>\n" +
                "</tr>\n" +

                "</table>\n" +
                "</body>\n" +
                "</html>"
      );
    }
}
