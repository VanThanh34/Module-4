package com.codegym.entity;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String nhacc;

    public Product() {
    }

    public Product(int id, String name, double price, String description, String nhacc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.nhacc = nhacc;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNhacc() {
        return nhacc;
    }

    public void setNhacc(String nhacc) {
        this.nhacc = nhacc;
    }
}
