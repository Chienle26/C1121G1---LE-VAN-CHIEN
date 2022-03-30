package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping({"","/calculator"})
    public String goCalculator(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public String goCalculateResult(@RequestParam Double number1,
                            @RequestParam Double number2,
                            @RequestParam (required = false) String addition,
                            @RequestParam (required = false) String subtraction,
                            @RequestParam (required = false) String multiplication,
                            @RequestParam (required = false) String division,
                            Model model){
        Double result = calculate(number1,number2,addition,subtraction,multiplication,division);
        model.addAttribute("result",result);
        return "calculator";
    }

    public Double calculate(Double number1, Double number2, String addition, String subtraction,String multiplication,String division){
        if (addition != null){
            return number1 + number2;
        }

        if (subtraction != null){
            return number1 - number2;
        }

        if (multiplication != null){
            return number1 * number2;
        }

        if (division != null && number2 != 0){
            return number1 / number2;
        }

        return null;
    }
}
