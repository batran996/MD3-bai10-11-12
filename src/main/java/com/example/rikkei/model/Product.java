package com.example.rikkei.model;

public class Product {
    private int id;
    private String name;
    private float price;
    private  int storage;

    public Product(String name, float price, int storage) {
        this.name = name;
        this.price = price;
        this.storage = storage;
    }

    public Product(int id, String name, float price, int storage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.storage = storage;
    }

    public int getId() {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", Storage=" + storage +
                '}';
    }

}
