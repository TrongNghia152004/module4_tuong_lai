package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Dictionary {
    @GetMapping("/dictionary")
    public String dictionary(@RequestParam(required = false) String english , Model model){
        if (english == null){
            model.addAttribute("english",english);
            return "search";
        }
        List<String> list = new ArrayList<>();
        list.add("red");
        list.add("blue");
        list.add("green");
        model.addAttribute("english",english);
        int index = list.indexOf(english);
        List<String> listViet = new ArrayList<>();
        listViet.add("đỏ");
        listViet.add("xanh dương");
        listViet.add("xanh lá");
        String result = listViet.get(index);
        model.addAttribute("result",result);
        return "search";
    }
}
