package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Province;

public interface IProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id) throws ResourceNotFoundException;

    void save(Province province);

    void remove(Long id);
}
