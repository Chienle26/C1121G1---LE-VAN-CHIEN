package com.chienle.controller;

import com.chienle.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @GetMapping({"/", "/list"})
    public String goList(Model model, @PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> search) {
        String keyword = search.orElse("");
        model.addAttribute("customers", iCustomerService.findAllPaging(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "customer/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model){

        return "/customer/create";
    }


}
