package com.example.service.impl;

import com.example.dto.ImgDTO;
import com.example.dto.ProductDTO;
import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO;
        for (Product product : productList) {
            productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<ImgDTO> findAllUrl() {
        List<Product> productList = productRepository.findAll();
        List<ImgDTO> productImgUrlDTOList = new ArrayList<>();
        ImgDTO imgDTO;
        for (Product product : productList) {
            imgDTO = new ImgDTO();
            BeanUtils.copyProperties(product, imgDTO);
            productImgUrlDTOList.add(imgDTO);
        }
        return productImgUrlDTOList;
    }

    @Override
    public ProductDTO findById(int id) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(productRepository.findById(id).get(), productDTO);
        return productDTO;
    }
}