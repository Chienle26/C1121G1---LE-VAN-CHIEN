package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {

    @GetMapping({"","/sandwich_condiments"})
    public String goSandwichCondiments(){
        return "/sandwich_condiments";
    }

    @GetMapping("/sandwich_condiments_choosed")
    public String goSandwichCondimentsChoosed(@RequestParam (required = false) String lettuce,
                                              @RequestParam (required = false) String tomato,
                                              @RequestParam (required = false) String mustard,
                                              @RequestParam (required = false) String sprouts,
                                              Model model){
        model.addAttribute("lettuce",lettuce);
        model.addAttribute("tomato",tomato);
        model.addAttribute("mustard",mustard);
        model.addAttribute("sprouts",sprouts);

        return "sandwich_condiments_choosed";
    }
}
