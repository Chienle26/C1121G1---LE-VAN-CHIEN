package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping({"", "/list"})
    public String goCategoryList(Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "category/list";
    }

    @GetMapping("/create")
    public String goCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String saveCategory(Category category) {
        iCategoryService.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/{id}/edit")
    public String goEditCategory(@PathVariable Integer id, Model model){
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public  String updateCategory(Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("success","Chỉnh sửa category thành công!");
        return "redirect:/category/list";
    }

    @GetMapping("/{id}/delete")
    public  String goDeleteCategory(Model model, @PathVariable Integer id){
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/delete")
    public String deleteCategory(Category category, RedirectAttributes redirectAttributes){
        iCategoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("success","Xóa category thành công!");
        return "redirect:/category/list";
    }

}
