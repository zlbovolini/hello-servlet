package com.github.zlbovolini.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

    private static final List<Company> companies = new ArrayList<>();

    static {
        companies.addAll(List.of(
                new Company("Alura", new Date()),
                new Company("Caelum", new Date()))
        );
    }

    public void save(Company company) {
        companies.add(company);
    }

    public List<Company> findAll() {
        return companies;
    }
}
