package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @GetMapping({"", "/list"})
    public String goBlogList(Model model) {
        model.addAttribute("blogList", iBlogService.findAll());
        return "list";
    }

    @GetMapping("/{id}/view")
    public String goViewBlog(Model model, @PathVariable Integer id) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";
    }

    @GetMapping("/create")
    public String goCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String saveBlog(Blog blog) {
        blog.setDate(String.valueOf((LocalDate.now())));
        iBlogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping("/{id}/edit")
    public String goEditBlog(@PathVariable Integer id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public  String updateBlog(Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("success","Chỉnh sửa blog thành công!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public  String goDeleteBlog(Model model, @PathVariable Integer id){
        model.addAttribute("blog",iBlogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("success","Xóa thành công!");
        return "redirect:/list";
    }

    @PostMapping("/search")
    public String goSearchByAuthor(Model model, @PathVariable String search){
        model.addAttribute("blogList",iBlogService.searchByNameAuthor(search));
        return "search";
    }
}
