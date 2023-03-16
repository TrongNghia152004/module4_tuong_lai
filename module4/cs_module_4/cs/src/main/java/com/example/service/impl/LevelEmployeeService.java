package com.example.service.impl;

import com.example.dto.LevelEmployeeDTO;
import com.example.model.LevelEmployee;
import com.example.repository.IEmployeeRepository;
import com.example.service.ILevelEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelEmployeeService implements ILevelEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public Page<LevelEmployeeDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<LevelEmployeeDTO> findAllList() {
        return null;
    }

    @Override
    public LevelEmployeeDTO findById(int id) {
        return null;
    }

    @Override
    public LevelEmployee findLevelEmployeeByName(String name) {
        return null;
    }

    @Override
    public void add(LevelEmployeeDTO levelEmployeeDTO) {

    }

    @Override
    public void delete(LevelEmployeeDTO levelEmployeeDTO) {

    }

    @Override
    public void update(LevelEmployeeDTO levelEmployeeDTO) {

    }
}
