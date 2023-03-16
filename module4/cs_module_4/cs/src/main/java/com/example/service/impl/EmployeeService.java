package com.example.service.impl;

import com.example.dto.EmployeeDTO;
import com.example.dto.LevelEmployeeDTO;
import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.repository.ILevelEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Autowired
    private ILevelEmployeeRepository iLevelEmployeeRepository;

    @Override
    public Page<EmployeeDTO> findAll(Pageable pageable, String title) {
        Page<Employee> employeePage = iEmployeeRepository.findEmployee(pageable, title);
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO employeeDTO;
        for (Employee employee : employeePage) {
            employeeDTO = new EmployeeDTO();
            employeeDTO.setLevelEmployeeDTO(new LevelEmployeeDTO());
            BeanUtils.copyProperties(employee.getLevelEmployee(), employeeDTO.getLevelEmployeeDTO());
            BeanUtils.copyProperties(employee, employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return new PageImpl<>(employeeDTOList, pageable, employeePage.getTotalElements());
    }

    @Override
    public EmployeeDTO findById(int id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employee = iEmployeeRepository.findById(id).get();
        employeeDTO.setLevelEmployeeDTO(new LevelEmployeeDTO());
        BeanUtils.copyProperties(employee.getLevelEmployee(),employeeDTO.getLevelEmployeeDTO());
        BeanUtils.copyProperties(employee,employeeDTO);
        return employeeDTO;
    }

    @Override
    public void add(EmployeeDTO employeeDTO) {
    Employee employee = new Employee();
    employee.setLevelEmployee(iLevelEmployeeRepository.findLevelEmployeeByName(employeeDTO.getLevelEmployeeDTO().getName()));
    BeanUtils.copyProperties(employeeDTO,employee);
    iEmployeeRepository.save(employee);
    }

    @Override
    public void update(EmployeeDTO employeeDTO) {

    }

    @Override
    public void delete(EmployeeDTO employeeDTO) {

    }
}
