package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showCategoryList(Model model , String name ,@PageableDefault(size = 5) Pageable pageable) {
        if (name == null){
            name = "";
        }
        model.addAttribute("category",categoryService.listAll());
        Page<Category> categoryPage = categoryService.findAll(name,pageable);
        model.addAttribute("categoryList", categoryPage);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= categoryPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList",pageNumberList);
        return "list-category";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "/create-category";
    }

    @PostMapping("/create")
    public String performCreate(@ModelAttribute Category category) {
        categoryService.createCategory(category);
        return "redirect:/blog";
    }
}