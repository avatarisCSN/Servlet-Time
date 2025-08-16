package org.example.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "SomeServlet", value = "/time")
public class SomeServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String timed;

        String[] vars = request.getParameterValues("var");
        Enumeration<String> parameterNames = request.getParameterNames();

        String str2 = request.getParameter("timezone");
        System.out.println(str2);
        try {

            String normalized = str2.replace("UTC", "").replace("GMT", "");
            System.out.println(normalized);

            int digits = Integer.parseInt(normalized);

            if( digits < -12 || digits > 12 ) {
                throw new IllegalArgumentException("Invalid timezone format: " + str2);
            } else {
                ZoneOffset offset = ZoneOffset.of(normalized); // умеет парсить "+02", "-05", "+02:30"
                System.out.println(offset);
                OffsetTime time = OffsetTime.now(offset);

                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + "Current time - " + time.truncatedTo(ChronoUnit.SECONDS) + "</h1>");
                out.println("</body></html>");
            }

        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid timezone format: " + str2);
        }



    }

    public void destroy() {}
}