package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showCategoryList(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
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