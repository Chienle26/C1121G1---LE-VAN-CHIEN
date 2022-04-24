package com.chienle.controller;

import com.chienle.dto.CustomerDto;
import com.chienle.dto.EmloyeeDto;
import com.chienle.model.customer.Customer;
import com.chienle.model.employee.Employee;
import com.chienle.model.user_role.User;
import com.chienle.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping({"", "/list"})
    public String goList(Model model, @PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> search) {
        String keyword = search.orElse("");
        model.addAttribute("employees", iEmployeeService.findAllPaging(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "employee/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("employee", new EmloyeeDto());
        model.addAttribute("user", new User());
        model.addAttribute("divisions", iEmployeeService.findAllDivision());
        model.addAttribute("educations", iEmployeeService.findAllEducationDegree());
        model.addAttribute("positions", iEmployeeService.findAllPosition());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute EmloyeeDto emloyeeDto, RedirectAttributes redirectAttributes) {
        Employee employee = new Employee();

        BeanUtils.copyProperties(emloyeeDto, employee);
        employee.setDivision(emloyeeDto.getDivision());
        employee.setEducationDegree(emloyeeDto.getEducationDegree());
        employee.setPosition(emloyeeDto.getPosition());
        employee.setUser(emloyeeDto.getUser());

        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Tạo mới thành công!");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    private String goEdit(@PathVariable Integer id, Model model) {
        Employee employee = iEmployeeService.findById(id);
        EmloyeeDto emloyeeDto = new EmloyeeDto();

        BeanUtils.copyProperties(employee, emloyeeDto);
        emloyeeDto.setDivision(employee.getDivision());
        emloyeeDto.setEducationDegree(employee.getEducationDegree());
        emloyeeDto.setPosition(employee.getPosition());
        emloyeeDto.setUser(employee.getUser());

        model.addAttribute("employeeDto", emloyeeDto);
        model.addAttribute("divisions", iEmployeeService.findAllDivision());
        model.addAttribute("educations", iEmployeeService.findAllEducationDegree());
        model.addAttribute("positions", iEmployeeService.findAllPosition());
        return "employee/edit";
    }

    @PostMapping("/update")
    private String update(@ModelAttribute EmloyeeDto emloyeeDto, RedirectAttributes redirectAttributes) {

        Employee employee = new Employee();

        BeanUtils.copyProperties(emloyeeDto, employee);
        employee.setDivision(emloyeeDto.getDivision());
        employee.setEducationDegree(emloyeeDto.getEducationDegree());
        employee.setPosition(emloyeeDto.getPosition());
        employee.setUser(emloyeeDto.getUser());

        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    private String delete(@RequestParam("idDelete") Integer idDelete, RedirectAttributes redirectAttributes) {
        Employee employee = iEmployeeService.findById(idDelete);
        employee.setActive(0);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/employee";
    }

}
