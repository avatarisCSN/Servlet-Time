package org.example.web;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(value = "/time")
public class TimezoneValidateFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req,
                            HttpServletResponse resp,
                            FilterChain chain) throws IOException, ServletException {

        String parameter = req.getParameter("timezone");

        if (parameter != null)  {
            chain.doFilter(req, resp);
        } else {
            resp.setStatus(400);

            resp.setContentType("application/json");
            resp.getWriter().write("{\"Error\": \"Not authorized\"}");
            resp.getWriter().close();
        }
    }
}
