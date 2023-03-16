package com.example.service;

import com.example.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService{
Page<EmployeeDTO> findAll(Pageable pageable , String title);
EmployeeDTO findById(int id);
void add(EmployeeDTO employeeDTO);
void update(EmployeeDTO employeeDTO);
void delete(EmployeeDTO employeeDTO);
}
