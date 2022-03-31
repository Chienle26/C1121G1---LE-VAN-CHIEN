package com.codegym.controller;

import com.codegym.model.ToKhaiYTe;
import com.codegym.service.IToKhaiYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToKhaiYTeController {
    @Autowired
    IToKhaiYTeService iToKhaiYTeService;

    @GetMapping({"/tokhaiyte",""})
    public String showForm(Model model) {
        model.addAttribute("quocTich", iToKhaiYTeService.getAllQuocTich());
        model.addAttribute("gioiTinh", iToKhaiYTeService.getAllGioiTinh());
        model.addAttribute("tinhThanh", iToKhaiYTeService.getAllTinhThanh());
        model.addAttribute("quanHuyen", iToKhaiYTeService.getAllQuanHuyen());
        model.addAttribute("phuongXa", iToKhaiYTeService.getAllPhuongXa());
        model.addAttribute("coKhong", iToKhaiYTeService.getAllCoKhong());
        model.addAttribute("phuongTien", iToKhaiYTeService.getAllPhuongTien());
        model.addAttribute("toKhaiYTe", new ToKhaiYTe());
        return "to_khai_y_te";
    }

    @PostMapping("/tokhaiyte")
    public String khaiBaoYTe(@ModelAttribute ToKhaiYTe toKhaiYTe, Model model) {
        iToKhaiYTeService.save(toKhaiYTe);
        model.addAttribute("toKhaiYTe", toKhaiYTe);
        model.addAttribute("message", "Khai báo thành công!");

        return "khai_bao_thanh_cong";
    }
}
