package com.chienle.controller;

import com.chienle.dto.EmployeeDto;
import com.chienle.model.employee.Employee;
import com.chienle.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.addAttribute("employeeDto", new EmployeeDto());
//        model.addAttribute("user", new User());
        model.addAttribute("divisions", iEmployeeService.findAllDivision());
        model.addAttribute("educations", iEmployeeService.findAllEducationDegree());
        model.addAttribute("positions", iEmployeeService.findAllPosition());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("divisions", iEmployeeService.findAllDivision());
            model.addAttribute("educations", iEmployeeService.findAllEducationDegree());
            model.addAttribute("positions", iEmployeeService.findAllPosition());
            return "employee/create";
        }

        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeDto, employee);
        employee.setDivision(employeeDto.getDivision());
        employee.setEducationDegree(employeeDto.getEducationDegree());
        employee.setPosition(employeeDto.getPosition());
        employee.setUser(employeeDto.getUser());

        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Tạo mới thành công!");
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    private String goEdit(@PathVariable Integer id, Model model) {
        Employee employee = iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();

        BeanUtils.copyProperties(employee, employeeDto);
        employeeDto.setDivision(employee.getDivision());
        employeeDto.setEducationDegree(employee.getEducationDegree());
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setUser(employee.getUser());

        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("divisions", iEmployeeService.findAllDivision());
        model.addAttribute("educations", iEmployeeService.findAllEducationDegree());
        model.addAttribute("positions", iEmployeeService.findAllPosition());
        return "employee/edit";
    }

    @PostMapping("/update")
    private String update(@ModelAttribute EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {

        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeDto, employee);
        employee.setDivision(employeeDto.getDivision());
        employee.setEducationDegree(employeeDto.getEducationDegree());
        employee.setPosition(employeeDto.getPosition());
        employee.setUser(employeeDto.getUser());

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
