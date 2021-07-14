package com.github.zlbovolini.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

    private static final List<Company> companies = new ArrayList<>();
    private static int idSeq = 0;

    static {
        companies.addAll(List.of(
                new Company(idSeq, "Alura", new Date()),
                new Company(++idSeq, "Caelum", new Date()))
        );
    }

    public void save(Company company) {
        companies.add(company);
    }

    public List<Company> findAll() {
        return companies;
    }

    public void delete(int id) {
        companies.stream()
                .filter(company -> company.getId() == id)
                .findAny()
                .ifPresent(companies::remove);
    }

    public Company findById(int id) {
        return companies.stream()
                .filter(company -> company.getId() == id)
                .findAny().orElse(new Company());
    }

    public void edit(Company company) {
        companies.stream()
                .filter(e -> e.getId() == company.getId())
                .findAny()
                .ifPresent(e -> {
                    companies.remove(e);
                    companies.add(company);
                });
    }
}
