package com.chienle.controller;

import com.chienle.model.BatDongSan;
import com.chienle.model.DanhMuc;
import com.chienle.service.IDanhMucService;
import com.chienle.service.impl.BatDongSanService;
import com.chienle.service.impl.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPMessageHandlers;
import java.util.List;

@RestController
@CrossOrigin("*")
public class BatDongSanController {
    @Autowired
    private DanhMucService danhMucService;

    @Autowired
    private BatDongSanService batDongSanService;

    @ModelAttribute
    public List<DanhMuc> getAllDanhMuc() {
        return danhMucService.findAll();
    }

    @ModelAttribute
    public List<BatDongSan> getAllBatDongSan() {
        return batDongSanService.findAll();
    }

    @GetMapping("/bat-dong-san/list")
    public ResponseEntity<List<BatDongSan>> getListBatDongSan() {
        List<BatDongSan> batDongSans = getAllBatDongSan();
        return new ResponseEntity<>(batDongSans, HttpStatus.OK);
    }

    @GetMapping("/danh-muc/list")
    public ResponseEntity<List<DanhMuc>> getListDanhMuc() {
        List<DanhMuc> danhMucs = this.danhMucService.findAll();
        return new ResponseEntity<>(danhMucs, HttpStatus.OK);
    }

    @PostMapping("/bat-dong-san/create")
    public ResponseEntity<Void> createBatDongSan(BatDongSan batDongSan) {
        batDongSanService.create(batDongSan);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/bat-dong-san/delete{id}")
    public ResponseEntity<Void> deleteBatDongSan(@PathVariable Integer id){
        this.batDongSanService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
