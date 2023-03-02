package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listProductByName(String name);
    void createProduct (Product product);
    Product findById (int id);
    void updateProduct(Product product);
    void deleteProduct (int id);
}
