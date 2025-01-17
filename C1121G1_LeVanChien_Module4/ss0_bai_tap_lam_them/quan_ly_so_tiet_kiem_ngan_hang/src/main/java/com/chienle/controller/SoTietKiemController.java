package com.chienle.controller;

import com.chienle.dto.KhachHangDto;
import com.chienle.dto.SoTietKiemDto;
import com.chienle.model.KhachHang;
import com.chienle.model.SoTietKiem;
import com.chienle.service.ISoTietKiemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SoTietKiemController {

    @Autowired
    ISoTietKiemService iSoTietKiemService;

    @GetMapping({"", "/list"})
    public String goListSoTietKiem(Model model,@RequestParam Optional<String> searchTen) {
        String searchTheoTen = searchTen.orElse("");
        model.addAttribute("soTietKiemSearchs",iSoTietKiemService.findByName(searchTheoTen));
        model.addAttribute("soTietKiems", iSoTietKiemService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String goCreateSoTietKiem(Model model) {
        model.addAttribute("soTietKiemDto", new SoTietKiemDto());
        return "create";
    }

    @PostMapping("/save")
    public String saveSoTietKiem(@Valid @ModelAttribute SoTietKiemDto soTietKiemDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        soTietKiemDto.validate(soTietKiemDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "create";
        }

        SoTietKiem soTietKiem = new SoTietKiem();
        BeanUtils.copyProperties(soTietKiemDto, soTietKiem);

        KhachHang khachHang = new KhachHang();
        khachHang.setId(soTietKiemDto.getKhachHangDto().getId());
        khachHang.setTen(soTietKiemDto.getKhachHangDto().getTen());
        soTietKiem.setKhachHang(khachHang);

        iSoTietKiemService.save(soTietKiem);
        redirectAttributes.addFlashAttribute("success", "Thêm mới sổ tiết kiệm thành công!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/edit")
    public String goEditSoTietKiem(Model model, @PathVariab le Integer id) {
        SoTietKiem soTietKiem = iSoTietKiemService.findById(id);

        SoTietKiemDto soTietKiemDto = new SoTietKiemDto();
        BeanUtils.copyProperties(soTietKiem, soTietKiemDto);

        KhachHangDto khachHangDto = new KhachHangDto();
        khachHangDto.setId(soTietKiem.getKhachHang().getId());
        khachHangDto.setTen(soTietKiem.getKhachHang().getTen());
        soTietKiemDto.setKhachHangDto(khachHangDto);
        model.addAttribute("soTietKiemDto", soTietKiemDto);
        return "edit";
    }

    @PostMapping("/update")
    public String updateSoTietKiem(@Valid @ModelAttribute SoTietKiemDto soTietKiemDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        soTietKiemDto.validate(soTietKiemDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }

        SoTietKiem soTietKiem = new SoTietKiem();
        BeanUtils.copyProperties(soTietKiemDto, soTietKiem);

        KhachHang khachHang = new KhachHang();
        khachHang.setId(soTietKiemDto.getKhachHangDto().getId());
        khachHang.setTen(soTietKiemDto.getKhachHangDto().getTen());
        soTietKiem.setKhachHang(khachHang);

        iSoTietKiemService.save(soTietKiem);
        redirectAttributes.addFlashAttribute("success", "Sửa sổ tiết kiệm thành công!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String goDeleteSoTietKiem(Model model, @PathVariable Integer id) {
        model.addAttribute("soTietKiem", iSoTietKiemService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteSoTietKiem(@ModelAttribute SoTietKiem soTietKiem, RedirectAttributes redirectAttributes) {
        iSoTietKiemService.delete(soTietKiem);
        redirectAttributes.addFlashAttribute("success", "Xóa sổ tiết kiệm thành công!");
        return "redirect:/list";
    }

}
