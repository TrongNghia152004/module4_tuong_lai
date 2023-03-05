package com.example.service;

import com.example.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void createCategory(Category category);
}
