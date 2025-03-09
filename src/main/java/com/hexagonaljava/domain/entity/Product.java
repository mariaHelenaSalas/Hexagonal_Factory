package com.hexagonaljava.domain.entity;

public class Product {
    private int id;
    private String name;
    private String stock;
    public Product(String stock, String name, int id) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public Product(int int1, String string, int id){
        return;
    }
    public  int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getstock() {
        return stock;
    }
    public void setstock(String stock) {
        this.stock = stock;
    }
    
}
