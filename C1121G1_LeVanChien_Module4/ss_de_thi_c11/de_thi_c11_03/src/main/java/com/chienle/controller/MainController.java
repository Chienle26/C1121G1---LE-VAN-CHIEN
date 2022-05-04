package com.chienle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String goHome() {
        return "home";
    }

    @GetMapping("/list")
    public String goList() {
        return "list";
    }
}
