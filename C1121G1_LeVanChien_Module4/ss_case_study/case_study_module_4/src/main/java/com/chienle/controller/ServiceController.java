package com.chienle.controller;

import com.chienle.dto.ServiceDto;
import com.chienle.model.service_entity.Service;
import com.chienle.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    IServiceService iServiceService;

    @GetMapping({"", "/list"})
    public String goList(Model model) {
        model.addAttribute("services", iServiceService.findAllService());
        model.addAttribute("serviceTypes", iServiceService.findAllServiceType());
        model.addAttribute("rentTypes", iServiceService.findAllRentType());
        return "service/list";
    }

    @GetMapping("/create/{id}")
    public String goCreate(Model model, @PathVariable Integer id) {
        model.addAttribute("service", new ServiceDto());
        model.addAttribute("serviceTypes", iServiceService.findAllServiceType());
        model.addAttribute("rentTypes", iServiceService.findAllRentType());
        model.addAttribute("id", id);
        return "service/create";
    }

    @PostMapping("/save")
    private String save(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("serviceTypes", iServiceService.findAllServiceType());
            model.addAttribute("rentTypes", iServiceService.findAllRentType());
//            model.addAttribute("id", id);
            return "service/create";
        }

        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        service.setServiceType(serviceDto.getServiceType());
        service.setRentType(serviceDto.getRentType());

        iServiceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Tạo mới thành công!");
        return "redirect:/service";
    }
}
