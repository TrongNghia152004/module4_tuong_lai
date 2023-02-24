package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Convert {
    @GetMapping("/convert")
    public String convert(@RequestParam(required = false) Double USD, Model model) {
        if (USD == null){
            model.addAttribute("USD", USD);
            return "result";
        }
        double VND = USD * 23000;
        model.addAttribute("VND", VND);
        model.addAttribute("USD", USD);
        return "result";
    }
}
