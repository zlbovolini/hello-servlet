package com.github.zlbovolini.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/removeEmpresa")
public class DeleteCompanyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramId = req.getParameter("id");
        int id = Integer.parseInt(paramId);

        Database database = new Database();

        database.delete(id);

        resp.sendRedirect("listaEmpresas");
    }
}
