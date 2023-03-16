package com.example.controller;

import com.example.dto.EmployeeDTO;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<EmployeeDTO> getEmployeeList(@Valid @PageableDefault(size = 3) Pageable pageable, @RequestParam(required = false, defaultValue = "") String name) {
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),sort);
        return iEmployeeService.findAll(sortedPageable,name);
    }
}
