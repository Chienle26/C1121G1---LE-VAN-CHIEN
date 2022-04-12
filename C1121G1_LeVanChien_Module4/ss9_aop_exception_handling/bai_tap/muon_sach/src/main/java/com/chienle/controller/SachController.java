package com.chienle.controller;

import com.chienle.model.Sach;
import com.chienle.model.TheMuon;
import com.chienle.service.ISachService;
import com.chienle.service.ITheMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SachController {

    @Autowired
    ISachService iSachService;

    @Autowired
    ITheMuonService iTheMuonService;

    @GetMapping({"", "/list"})
    public String goListSach(Model model) {
        model.addAttribute("sachs", iSachService.findAll());
        return "list";
    }

    @GetMapping("/{id}/borrow")
    public String goMuonSach(Model model, @PathVariable Integer id) {
        model.addAttribute("sach", iSachService.findById(id));
        return "borrow";
    }

    @PostMapping("/save")
    public String MuonSach(Sach sach, RedirectAttributes redirectAttributes) {
        if (sach.getSoLuong() <= 0) {
            redirectAttributes.addFlashAttribute("success", "Mượn không thành công vì đã hết sách!");
            return "redirect:/list";
        }
        TheMuon theMuon = new TheMuon();
        theMuon.setId((int) (Math.random() * 100000));
        theMuon.setTrangThai(true);
        theMuon.setSach(sach);
        iTheMuonService.save(theMuon);
        sach.setSoLuong(sach.getSoLuong() - 1);
        iSachService.save(sach);
        redirectAttributes.addFlashAttribute("success", "Mượn thành công!");
        return "redirect:/list";
    }

    @GetMapping("/return_list")
    public String goListTheMuon(Model model) {
        model.addAttribute("theMuons", iTheMuonService.findAll());
        return "list_the_muon";
    }

    @PostMapping("/return")
    public String traSach(@RequestParam Integer maTheMuon, Model model) {
        TheMuon theMuon = iTheMuonService.findById(maTheMuon);
        Sach sach = theMuon.getSach();

        if (theMuon.getTrangThai() == false) {
            model.addAttribute("theMuons", iTheMuonService.findAll());
            model.addAttribute("success", "Bạn có mượn sách gì đâu mà trả???");
            return "list_the_muon";
        }

        theMuon.setTrangThai(false);
        iTheMuonService.save(theMuon);
        sach.setSoLuong(sach.getSoLuong() + 1);
        iSachService.save(sach);

        model.addAttribute("theMuons", iTheMuonService.findAll());
        model.addAttribute("success", "Trả sách thành công!");
        return "list_the_muon";
    }

    @GetMapping("/{id}/view")
    public String goDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("sach", iSachService.findById(id));
        return "view";
    }
}
