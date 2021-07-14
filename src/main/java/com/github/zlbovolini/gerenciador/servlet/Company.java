package com.github.zlbovolini.gerenciador.servlet;

import java.util.Date;

public class Company {

    private Integer id;
    private String name;
    private Date foundedAt;

    public Company() {
    }

    public Company(String name, Date foundedAt) {
        this.name = name;
        this.foundedAt = foundedAt;
    }

    public Company(Integer id, String name, Date foundedAt) {
        this(name, foundedAt);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(Date foundedAt) {
        this.foundedAt = foundedAt;
    }
}
