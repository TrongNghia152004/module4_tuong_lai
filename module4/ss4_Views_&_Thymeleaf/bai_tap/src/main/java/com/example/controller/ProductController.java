package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    IProductService iProductService = new ProductService();

    @GetMapping("")
    public String list(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("product", iProductService.listProductByName(name));
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product) {
        iProductService.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        iProductService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/information/{id}")
    public String showInformation(@PathVariable int id, Model model) {
        model.addAttribute("productInform", iProductService.findById(id));
        return "/information";
    }

    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product) {
        iProductService.updateProduct(product);
        return "redirect:/product";
    }
}
