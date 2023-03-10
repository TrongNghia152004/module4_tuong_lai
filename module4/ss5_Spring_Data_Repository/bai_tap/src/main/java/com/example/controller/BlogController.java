package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showBlogList(@RequestParam(required = false, defaultValue = "") String name, Model model, @PageableDefault(size = 5) Pageable pageable) {
        if (name == null) {
            name = "";
        }
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Blog> blogPage = blogService.findAll(name, sortedPageable);
        model.addAttribute("blogList", blogPage);
        model.addAttribute("name", name);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= blogPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList" , pageNumberList);
        return "/list";
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/create")
    public String showCreateForm(Model model, String name, Pageable pageable) {
        if (name == null) {
            name = "";
        }
        model.addAttribute("categoryList", categoryService.findAll(name, pageable));
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate(@ModelAttribute Blog blog) {
        blogService.createBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String showBlogDetail(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "/detail";
    }

    @GetMapping("/delete")
    public String performDelete(@RequestParam Integer deleteId) {
        blogService.deleteBlog(deleteId);
        return "redirect:/blog";
    }

    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam Integer id, Model model, String name, Pageable pageable) {
        if (name == null) {
            name = "";
        }
        model.addAttribute("categoryList", categoryService.findAll(name, pageable));
        model.addAttribute("blog", blogService.findBlogById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String performUpdate(@ModelAttribute Blog blog) {
        blogService.updateBlog(blog);
        return "redirect:/blog";
    }
}