package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping({"", "/list"})
    public String goList(Model model) {
        model.addAttribute("productList", iProductService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("product",iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("success","Chỉnh sửa thành công!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable int id){
        model.addAttribute("product",iProductService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success","Xóa thành công!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String search, Model model){
        model.addAttribute("productList",iProductService.searchByName(search));
        return "search";
    }

}
