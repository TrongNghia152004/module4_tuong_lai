package com.example.service;

import com.example.dto.ImgDTO;
import com.example.dto.ProductDTO;
import com.example.model.Cart;
import com.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDTO> findAll();
    List<ImgDTO> findAllUrl();
    ProductDTO findById (int id);
}
