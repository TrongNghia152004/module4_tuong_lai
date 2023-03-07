package com.example.service;

import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(String name , Pageable pageable);

    void createCategory(Category category);
    List<Category> listAll();
}
