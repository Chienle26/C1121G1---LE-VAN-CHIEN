package com.chienle.service.impl;

import com.chienle.model.BenhAn;
import com.chienle.repository.IBenhAnRepository;
import com.chienle.service.IBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenhAnService implements IBenhAnService {
    @Autowired
    IBenhAnRepository iBenhAnRepository;

    @Override
    public List<BenhAn> findAllBenhAn() {
        return iBenhAnRepository.findAll();
    }

    @Override
    public Page<BenhAn> findAllBenhAnPaging(String tenBenhNhan, Pageable pageable) {
        return iBenhAnRepository.findByBenhNhan_TenBenhNhanContaining(tenBenhNhan, pageable);
    }

    @Override
    public BenhAn findById(Integer id) {
        return iBenhAnRepository.findById(id).orElse(null);
    }


    @Override
    public void save(BenhAn benhAn) {
        iBenhAnRepository.save(benhAn);
    }

    @Override
    public void delete(BenhAn benhAn) {
        iBenhAnRepository.delete(benhAn);
    }
}
