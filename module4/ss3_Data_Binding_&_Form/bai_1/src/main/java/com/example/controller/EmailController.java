package com.example.controller;

import com.example.model.EmailBox;
import com.example.service.IEmailService;
import com.example.service.impl.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/email")
public class EmailController {
IEmailService iEmailService = new EmailService();
    @GetMapping("/showMail")
    public String showForm(Model model) {
        model.addAttribute("mailBox", iEmailService.getAllEmailBox());
        if (iEmailService.getAllEmailBox().isSpamsFilter()) {
            model.addAttribute("spamFilter", "Enable spams filter");
        } else model.addAttribute("spamFilter", "Disanable spams filter");


        return "/list";
    }
@GetMapping("")
    public String showUpdateForm(Model model){
    model.addAttribute("emailBox",iEmailService.getAllEmailBox());
    model.addAttribute("languages", Arrays.asList("English","Vietnamese","Japanese"));
    model.addAttribute("pageSize",Arrays.asList(5,10,15,25,50,100));
    return "/update";
}
@PostMapping("")
    public String performUpdateEmail(@ModelAttribute EmailBox emailBox , Model model){
    iEmailService.updateEmailBox(emailBox);
    model.addAttribute("emailBox",emailBox);
    return "redirect:/email";
}
}
