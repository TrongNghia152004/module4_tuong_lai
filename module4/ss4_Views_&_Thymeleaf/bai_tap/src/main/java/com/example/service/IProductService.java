package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> listProductByName(String name);
    void createProduct (Product product);
    Product findById (int id);
    void updateProduct(Product product);
    void deleteProduct (int id);
}
