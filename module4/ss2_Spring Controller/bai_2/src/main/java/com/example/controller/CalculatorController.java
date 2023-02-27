package com.example.controller;

import com.example.service.ICalculatorService;
import com.example.service.impl.CalculatorService;
import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    ICalculatorService iCalculatorService = new CalculatorService();

    @GetMapping("calculator")
    public String calculator(@RequestParam(required = false) Double firstNumber, Double secondNumber, String calculate, Model model) {
        if (firstNumber == null & secondNumber == null) {
            return "/calculation";
        }
        double result = iCalculatorService.performCalculator(calculate, firstNumber, secondNumber);
        model.addAttribute("result", result);
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        model.addAttribute("calculate", calculate);
        return "/calculation";
    }
}
