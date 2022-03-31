package com.codegym.controller;

import com.codegym.model.MailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailSettingController {

    @GetMapping({"/setting",""})
    public String goMailSetting(Model model){
        MailSetting mailSetting = new MailSetting();
        model.addAttribute("mailSetting",mailSetting);
        return "mail_setting";
    }

    @PostMapping("/setting")
    public String updateSetting(@RequestParam MailSetting mailSetting, Model model){
        model.addAttribute("mailSetting",mailSetting);
        return "home";
    }
}
