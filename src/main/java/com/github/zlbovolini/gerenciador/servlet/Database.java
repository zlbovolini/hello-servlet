package com.github.zlbovolini.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final List<Company> companies = new ArrayList<>();

    public void save(Company company) {
        companies.add(company);
    }

    public List<Company> findAll() {
        return companies;
    }
}
