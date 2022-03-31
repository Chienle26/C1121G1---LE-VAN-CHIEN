package com.codegym.controller;

import com.codegym.model.MailSetting;
import com.codegym.service.ISettingMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailSettingController {

    @Autowired
    ISettingMailService iSettingMailService;

    @GetMapping({"/setting",""})
    public String goMailSetting(Model model){
        MailSetting mailSetting = new MailSetting();
        model.addAttribute("mailSetting",mailSetting);
        model.addAttribute("listLanguage",iSettingMailService.listLanguage());
        model.addAttribute("listPageSize",iSettingMailService.listPageSize());
        return "mail_setting";
    }

    @PostMapping("/setting")
    public String updateSetting(@ModelAttribute MailSetting mailSetting, Model model){
        model.addAttribute("mailSetting",mailSetting);
        model.addAttribute("message","Update thành công!");
        return "home";
    }
}
