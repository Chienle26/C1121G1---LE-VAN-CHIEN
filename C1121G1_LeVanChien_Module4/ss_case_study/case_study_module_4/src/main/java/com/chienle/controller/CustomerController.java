package com.chienle.controller;

import com.chienle.dto.CustomerDto;
import com.chienle.model.customer.Customer;
import com.chienle.model.customer.CustomerType;
import com.chienle.service.ICustomerService;
import com.chienle.service.ICustomerUseServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerUseServiceService iCustomerUseServiceService;

    @GetMapping({"", "/list"})
    public String goList(Model model, @PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> search) {
        String keyword = search.orElse("");
        model.addAttribute("customers", iCustomerService.findAllPaging(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "customer/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("customerTypes", iCustomerService.findAllCustomerType());
        return "/customer/create";
    }

    @PostMapping("/save")
    private String save(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();

        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerDto.getCustomerType());

        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Tạo mới thành công!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    private String goEdit(@PathVariable Integer id, Model model) {
        Customer customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();

        BeanUtils.copyProperties(customer, customerDto);
        customerDto.setCustomerType(customer.getCustomerType());

        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypes", iCustomerService.findAllCustomerType());
        return "customer/edit";
    }

    @PostMapping("/update")
    private String update(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes) {

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerDto.getCustomerType());

        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        return "redirect:/customer";
    }

//    @GetMapping("/{id}/delete")
//    private String goDelete(Model model, @PathVariable Integer id) {
//        Customer customer = iCustomerService.findById(id);
//        model.addAttribute("customer", customer);
//        return "customer/delete";
//    }

    @PostMapping("/delete")
    private String delete(@RequestParam("idDelete") Integer idDelete, RedirectAttributes redirectAttributes) {
        Customer customer = iCustomerService.findById(idDelete);
        customer.setActive(0);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    private String goView(@PathVariable Integer id, Model model) {
        Customer customer = iCustomerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/view";
    }

    @GetMapping("/list-customer-use-service")
    public String goListCustomerUseService(Model model, @PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> search) {
        String keyword = search.orElse("");
        model.addAttribute("customerUseServices", iCustomerUseServiceService.findAllCustomerUseService(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "customer/list-customer-use-service";
    }
}
