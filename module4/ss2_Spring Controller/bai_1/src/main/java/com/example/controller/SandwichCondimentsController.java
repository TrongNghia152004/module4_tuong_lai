package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class SandwichCondimentsController {
    @GetMapping("/save-condiments")
    public String showForm() {
        return "/condiments";
    }

    @PostMapping("/save-condiments")
    public String save(@RequestParam("condiments") String condiment, Model model) {
        model.addAttribute("condiments", condiment);
        return "/condiments";
    }
}
