package com.hexagonaljava.domain.entity;

public class Product {
    private int id;
    private String name;
    private int stock;
    public Product(int id2, String name, int id) {
        this.id = id;
        this.name = name;
        this.stock = id2;
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
    public int getstock() {
        return stock;
    }
    public void setstock(int stock) {
        this.stock = stock;
    }
    
    public String toString() {
        return String.format("ID: %d | NOMBRE: %s | STOCK: %s", id, name, stock);
    }
}
