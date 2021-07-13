package com.github.zlbovolini.gerenciador.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/listaEmpresas")
public class ShowCompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Database database = new Database();
        List<Company> companies = database.findAll();

        PrintWriter writer = resp.getWriter();

        writer.println("<html><body>");
        writer.println("<ul>");

        for (Company company : companies) {
            writer.println("<li>" + company.getName() + "</li>");
        }

        writer.println("</ul>");
        writer.println("</body></html>");
    }
}
