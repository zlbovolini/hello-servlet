package com.github.zlbovolini.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/mostraEmpresa")
public class ShowCompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        int id = Integer.parseInt(paramId);

        Database database = new Database();
        Company company = database.findById(id);

        req.setAttribute("company", company);

        RequestDispatcher dispatcher = req.getRequestDispatcher("formAlteraEmpresa.jsp");
        dispatcher.forward(req, resp);
    }
}
