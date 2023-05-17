package com.rohit.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/footer")
    public String footerDesign(Model model){
        return "footer";
    }

    @GetMapping("/service")
    public String fragmentService(Model model){
        return "service";
    }
}