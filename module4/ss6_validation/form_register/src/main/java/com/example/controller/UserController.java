package com.example.controller;

import com.example.dto.UserDTO;
import com.example.model.User;
import com.example.service.impl.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public String showList (Model model) {
        model.addAttribute("userList", userService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/create";
    }

    @PostMapping("")
    public String performCreation (@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.create(user);
        redirectAttributes.addFlashAttribute("msg", "msg.createSuccess");
        return "redirect:/user";
    }
}
