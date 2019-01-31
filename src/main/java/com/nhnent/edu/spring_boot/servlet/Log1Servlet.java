package com.nhnent.edu.spring_boot.servlet;

import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO : #1 Servlet 예제 1.
public class Log1Servlet extends HttpServletBean {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Log1Servlet!");
    }

}
