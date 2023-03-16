package com.example.service;

import com.example.dto.EmployeeDTO;
import com.example.dto.LevelEmployeeDTO;
import com.example.model.LevelEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILevelEmployeeService {
Page<LevelEmployeeDTO> findAll(Pageable pageable);
List<LevelEmployeeDTO> findAllList();
LevelEmployeeDTO findById(int id);
LevelEmployee findLevelEmployeeByName(String name);
void add(LevelEmployeeDTO levelEmployeeDTO);
void delete(LevelEmployeeDTO levelEmployeeDTO);
void update(LevelEmployeeDTO levelEmployeeDTO);
}
