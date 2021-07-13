package com.github.zlbovolini.gerenciador.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NewCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Optional<String> optionalName = Optional.ofNullable(req.getParameter("name"));

        final PrintWriter writer = resp.getWriter();

        optionalName.filter(name -> !name.isBlank())
                .ifPresentOrElse(name -> {

                    Company company = new Company(name);
                    Database database = new Database();

                    database.save(company);

                    writer.println("<html><body>Empresa " + name + " cadastrada com sucesso!</body></html>");
                }, () -> {
                    writer.println("<html><body>Por favor, informe o nome da empresa.</body></html>");
                });

    }
}
