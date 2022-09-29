package com.example.rikkei.service;

import com.example.rikkei.model.Product;

import java.util.List;

public interface IProductService {
    List<Product>finAll();
    void save(Product product);
    Product findByID(int id);
    void delete(int id);
    List<Product> findByName(String name);
}
