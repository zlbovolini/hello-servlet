package com.github.zlbovolini.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NewCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Optional<String> optionalName = Optional.ofNullable(req.getParameter("name"));
        Optional<String> optionalFoundedAt = Optional.ofNullable(req.getParameter("foundedAt"));

        boolean isValid = Stream.of(optionalName, optionalFoundedAt).flatMap(Optional::stream).noneMatch(String::isBlank);

        if (!isValid) {
           resp.sendRedirect("formNovaEmpresa.jsp");
           return;
        }

        String name = optionalName.get();
        String foundedAt = optionalFoundedAt.get();

        Date foundedAtDate;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            foundedAtDate = dateFormat.parse(foundedAt);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Company company = new Company(name, foundedAtDate);
        Database database = new Database();

        database.save(company);

        req.setAttribute("name", company.getName());
        req.setAttribute("foundedAt", company.getFoundedAt());

        resp.sendRedirect("listaEmpresas");
    }
}
