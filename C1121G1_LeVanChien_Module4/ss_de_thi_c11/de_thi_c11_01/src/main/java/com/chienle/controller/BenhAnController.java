package com.chienle.controller;

import com.chienle.dto.BenhAnDto;
import com.chienle.dto.BenhNhanDto;
import com.chienle.model.BenhAn;
import com.chienle.model.BenhNhan;
import com.chienle.service.IBenhAnService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class BenhAnController {

    @Autowired
    IBenhAnService iBenhAnService;

    @GetMapping("")
    public String goHome() {
        return "home";
    }

    @GetMapping("/list")
    public String goList(Model model, @RequestParam Optional<String> search, @PageableDefault(value = 1) Pageable pageable) {
        String keyword = search.orElse("");
        model.addAttribute("benhAns", iBenhAnService.findAllBenhAnPaging(keyword, pageable));
        model.addAttribute("keyword", keyword);
        return "list";
    }

    @GetMapping("{id}/edit")
    public String goEdit(Model model, @PathVariable Integer id) {
        BenhAn benhAn = iBenhAnService.findById(id);
        BenhAnDto benhAnDto = new BenhAnDto();
        BenhNhanDto benhNhanDto = new BenhNhanDto();

        BeanUtils.copyProperties(benhAn, benhAnDto);
        BeanUtils.copyProperties(benhAn.getBenhNhan(), benhNhanDto);
        benhAnDto.setBenhNhanDto(benhNhanDto);

        model.addAttribute("benhAnDto", benhAnDto);
        return "edit";
    }

    @PostMapping("/update")
    public String edit(@Valid @ModelAttribute BenhAnDto benhAnDto, BindingResult bindingResult) {
        BenhNhanDto benhNhanDto = benhAnDto.getBenhNhanDto();
        benhAnDto.getBenhNhanDto().validate(benhNhanDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "edit";
        }

        BenhAn benhAn = new BenhAn();
        BenhNhan benhNhan = new BenhNhan();
        BeanUtils.copyProperties(benhAnDto, benhAn);
        BeanUtils.copyProperties(benhAnDto.getBenhNhanDto(), benhNhan);

        benhAn.setBenhNhan(benhNhan);

        iBenhAnService.save(benhAn);
        return "redirect:/list";
    }

    @PostMapping("/delete")
    public String delete(Integer idDelete) {
        iBenhAnService.delete(iBenhAnService.findById(idDelete));
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("benhAnDto", new BenhAnDto());
        return "create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute BenhAnDto benhAnDto) {
        BenhAn benhAn = new BenhAn();
        BeanUtils.copyProperties(benhAnDto, benhAn);
        BenhNhan benhNhan = new BenhNhan();
        BeanUtils.copyProperties(benhAnDto.getBenhNhanDto(), benhNhan);

        benhAn.setBenhNhan(benhNhan);

        iBenhAnService.save(benhAn);

        return "redirect:/list";
    }
}
