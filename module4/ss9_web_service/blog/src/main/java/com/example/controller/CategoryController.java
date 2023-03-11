package com.example.controller;

import com.example.dto.CategoryDTO;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<CategoryDTO> getCategories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CategoryDTO getCategory (@PathVariable int id) {
        return categoryService.findById(id);
    }
}
