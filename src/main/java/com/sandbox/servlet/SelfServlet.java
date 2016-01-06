package com.sandbox.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: zhangxin
 * Date:   16-1-6
 */
public class SelfServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Self Servlet</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h2>Servlet SelfServlet at: " + request.getContextPath() + "</h2>");
            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public String getServletInfo() {
        return "Selfservlet";
    }
}
