package com.chienle.controller;

import com.chienle.dto.KhuyenMaiDto;
import com.chienle.model.KhuyenMai;
import com.chienle.service.IKhuyenMaiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class KhuyenMaiController {
    @Autowired
    private IKhuyenMaiService iKhuyenMaiService;

    @GetMapping("")
    public String goHome() {
        return "home";
    }

    @GetMapping("/list")
    public String goList(Model model) {
        model.addAttribute("khuyenMais", iKhuyenMaiService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("khuyenMaiDto", new KhuyenMaiDto());
        return "create";
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute KhuyenMaiDto khuyenMaiDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        khuyenMaiDto.validate(khuyenMaiDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "create";
        }

        KhuyenMai khuyenMai = new KhuyenMai();

        BeanUtils.copyProperties(khuyenMaiDto, khuyenMai);

        iKhuyenMaiService.save(khuyenMai);

        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");

        return "redirect:/list";

    }

    @PostMapping("delete")
    public String delete(Integer idDelete, RedirectAttributes redirectAttributes) {

        iKhuyenMaiService.delete(iKhuyenMaiService.findById(idDelete));

        redirectAttributes.addFlashAttribute("message", "Xóa thành thành công!");

        return "redirect:/list";
    }

}
