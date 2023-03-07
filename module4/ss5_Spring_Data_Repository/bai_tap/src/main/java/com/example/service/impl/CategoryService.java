package com.example.service.impl;


import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.ICategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(String name , Pageable pageable) {
        return categoryRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

}
