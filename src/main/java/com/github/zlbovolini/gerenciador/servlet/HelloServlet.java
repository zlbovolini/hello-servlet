package com.github.zlbovolini.gerenciador.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println(String.format("<h1>Hello Servlet. Now is %s </h1>", LocalTime.now()));
        writer.println("</body>");
        writer.println("</html>");
    }
}
