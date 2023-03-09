package com.example.repository;

import com.example.model.Cart;
import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Cart,Integer> {

    Optional<Product> findById(Long id);
}
