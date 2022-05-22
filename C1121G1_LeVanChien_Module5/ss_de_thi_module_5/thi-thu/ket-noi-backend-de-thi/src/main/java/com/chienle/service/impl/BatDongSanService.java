package com.chienle.service.impl;

import com.chienle.model.BatDongSan;
import com.chienle.repository.IBatDongSanRepository;
import com.chienle.service.IBatDongSanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatDongSanService implements IBatDongSanService {
    @Autowired
    private IBatDongSanRepository iBatDongSanRepository;

    @Override
    public List<BatDongSan> findAll() {
        return iBatDongSanRepository.findAll();
    }

    @Override
    public void create(BatDongSan batDongSan) {
        this.iBatDongSanRepository.save(batDongSan);
    }

    @Override
    public BatDongSan findById(Integer id) {
        return this.iBatDongSanRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        this.iBatDongSanRepository.deleteById(id);
    }
}
