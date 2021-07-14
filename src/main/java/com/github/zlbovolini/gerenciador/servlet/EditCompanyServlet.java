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

@WebServlet(urlPatterns = "/alteraEmpresa")
public class EditCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> optionalId = Optional.ofNullable(req.getParameter("id"));
        Optional<String> optionalName = Optional.ofNullable(req.getParameter("name"));
        Optional<String> optionalFoundedAt = Optional.ofNullable(req.getParameter("foundedAt"));

        boolean isValid = Stream.of(optionalId, optionalName, optionalFoundedAt).flatMap(Optional::stream).noneMatch(String::isBlank);

        if (!isValid) {
            resp.sendRedirect("formAlteraEmpresa.jsp");
            return;
        }

        String paramId = optionalId.get();
        String name = optionalName.get();
        String foundedAt = optionalFoundedAt.get();

        Date foundedAtDate;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            foundedAtDate = dateFormat.parse(foundedAt);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        int id = Integer.parseInt(paramId);

        Company company = new Company(id, name, foundedAtDate);
        Database database = new Database();

        database.edit(company);

        resp.sendRedirect("listaEmpresas");
    }
}
