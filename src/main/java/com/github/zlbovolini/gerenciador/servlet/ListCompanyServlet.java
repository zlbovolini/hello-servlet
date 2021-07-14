package com.github.zlbovolini.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listaEmpresas")
public class ListCompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Database database = new Database();
        List<Company> companies = database.findAll();

        req.setAttribute("companies", companies);

        RequestDispatcher dispatcher = req.getRequestDispatcher("listaEmpresas.jsp");
        dispatcher.forward(req, resp);
    }
}
