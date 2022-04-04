package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.time.LocalDate;

@Controller
public class CommentController {

    @Autowired
    ICommentService iCommentService;

    @GetMapping({"","/image"})
    public String goImage(Model model){
        model.addAttribute("comment",new Comment());
        model.addAttribute("commentList",iCommentService.findAll());
        return "image";
    }

    @PostMapping(value = "create")
    public String create(@ModelAttribute Comment comment, Model model){
        comment.setDates(String.valueOf(LocalDate.now()));
        comment.setLikes(0);
        iCommentService.save(comment);
        return "redirect:/image";
    }

    @GetMapping(value = "/like")
    public String like(@RequestParam int idLike) {
        Comment comment = iCommentService.findById(idLike);
        iCommentService.like(comment);
        return "redirect:/image";
    }
}
