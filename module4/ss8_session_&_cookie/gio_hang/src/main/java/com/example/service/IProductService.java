package com.example.service;

import com.example.model.Cart;
import com.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Cart> findAll();
    Optional<Product> findById(Long id);
}
