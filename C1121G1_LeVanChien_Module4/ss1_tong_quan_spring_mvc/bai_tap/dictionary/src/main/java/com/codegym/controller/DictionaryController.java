package com.codegym.controller;

import com.codegym.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private ITranslateService translateService;

    @GetMapping({"","/search"})
    public String search(){
        return "/dictionary";
    }

    @GetMapping("/translate")
    public  String translate(@RequestParam String word, Model model){
        String result = translateService.findByWord(word);
        model.addAttribute("result",result);
        model.addAttribute("word",word);
        return "/translate";
    }
}
