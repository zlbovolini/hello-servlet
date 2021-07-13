package com.github.zlbovolini.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NewCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Optional<String> optionalName = Optional.ofNullable(req.getParameter("name"));

        if (optionalName.isPresent() && !optionalName.get().isBlank()) {
            String name = optionalName.get();

            Company company = new Company(name);
            Database database = new Database();

            database.save(company);

            req.setAttribute("name", company.getName());

            RequestDispatcher dispatcher = req.getRequestDispatcher("novaEmpresaCriada.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
