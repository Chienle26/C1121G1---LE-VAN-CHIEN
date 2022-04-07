package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.model.UserDto;
import com.codegym.service.IUserService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping({"", "/form"})
    public String goForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @PostMapping("/create")
    public String validationUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        userDto.validate(userDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "index";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.save(user);
        return "result";
    }
}
