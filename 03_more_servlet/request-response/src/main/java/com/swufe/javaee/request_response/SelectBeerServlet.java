package com.swufe.javaee.request_response;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectBeerServlet", value = "/SelectBeerServlet")
public class SelectBeerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String body = request.getParameter("body");
        String[] sizes = request.getParameterValues("sizes");
        if (body != null & request.getParameter("amount") != null & sizes != null) {
            int amount = Integer.parseInt(request.getParameter("amount")) + 2;
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>This is get the response</h1>");
            out.println("<p>body: " + body + "</p>");
            out.println("<p>amount: " + amount + "</p>");
            for (String s : sizes) {
                out.println("<p>sizes: " + s + "</p>");
            }
            out.println("</body></html>");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>This is get the response</h1>");
            out.println("<p>The information is invalid</p>");
            out.println("</body></html>");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String body = request.getParameter("body");
        String[] sizes = request.getParameterValues("sizes");
        if (body != null & request.getParameter("amount") != null & sizes != null) {
            int amount = Integer.parseInt(request.getParameter("amount")) + 2;
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>This is post response</h1>");
            out.println("<p>body: " + body + "</p>");
            out.println("<p>amount: " + amount + "</p>");
            for (String s : sizes) {
                out.println("<p>sizes: " + s + "</p>");
            }
            out.println("</body></html>");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>This is post response</h1>");
            out.println("<p>The information is invalid</p>");
            out.println("</body></html>");
        }
    }
}
