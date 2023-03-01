package com.example.controller;

import com.example.model.EmailBox;
import com.example.service.IEmailService;
import com.example.service.impl.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class EmailController {
IEmailService iEmailService = new EmailService();
    @GetMapping("/showEmail")
    public String showForm(Model model) {
        model.addAttribute("emailBox", iEmailService.getAllEmailBox());
        if (iEmailService.getAllEmailBox().isSpamsFilter()){
            model.addAttribute("spamFilter", "Enable spams filter");
        } else model.addAttribute("spamFilter", "Disanable spams filter");


        return "/list";
    }

    @GetMapping("/updateFormEmail")
    public String showUpdate(Model model) {
        model.addAttribute("emailBox", iEmailService.getAllEmailBox());
        model.addAttribute("languages", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSize", Arrays.asList(5, 10, 15, 20, 25, 50, 100));
        return "/update";
    }

    @PostMapping("/updateEmail")
    public String updateMail(@ModelAttribute EmailBox emailBox, RedirectAttributes redirectAttributes) {
        this.iEmailService.updateEmailBox(emailBox);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành công");
        return "redirect:/showEmail";
    }
}
