package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoneyController {

    @GetMapping({"","/convert"})
    public String inputConvert(){
        return "convert_money";
    }

    @PostMapping("/result")
    public String convertMoney(@RequestParam  double money, @RequestParam double price, Model model){
        Double resultCovert = money * price;
        model.addAttribute("result",resultCovert);
        model.addAttribute("money",money);
        return "/result_final";
    }
}
