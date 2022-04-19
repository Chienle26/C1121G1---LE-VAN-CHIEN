package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping(("/blog"))
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping({"", "/list"})
    public String goBlogList(Model model, @PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> search) {
        String keyword = search.orElse("");
        model.addAttribute("blogList", iBlogService.findAllPaging(keyword, pageable));
        model.addAttribute("categoryList",iCategoryService.findAll());
        model.addAttribute("keyword",keyword);
        return "blog/list";
    }

    @GetMapping("/{id}/view")
    public String goViewBlog(Model model, @PathVariable Integer id) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/create")
    public String goCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/save")
    public String saveBlog(Blog blog) {
        blog.setDate(String.valueOf((LocalDate.now())));
        iBlogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String goEditBlog(@PathVariable Integer id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("/update")
    public  String updateBlog(Blog blog, RedirectAttributes redirectAttributes){
        blog.setDate(String.valueOf(LocalDate.now()));
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("success","Chỉnh sửa blog thành công!");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public  String goDeleteBlog(Model model, @PathVariable Integer id){
        model.addAttribute("blog",iBlogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("success","Xóa thành công!");
        return "redirect:/";
    }
}
