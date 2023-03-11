package com.example.service;

import com.example.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<CategoryDTO> findAll(Pageable pageable);
    CategoryDTO findById(int id);
}
