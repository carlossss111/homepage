package com.daniel.homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daniel.homepage.entity.Example;


@Controller
public class HomepageController {

    @GetMapping("/")
    public String getHomepage(Model model) {
        model.addAttribute("example", new Example());
        return "index";
    }
    
}
