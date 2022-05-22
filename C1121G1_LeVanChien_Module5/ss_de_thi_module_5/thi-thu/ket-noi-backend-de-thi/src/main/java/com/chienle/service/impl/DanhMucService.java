package com.chienle.service.impl;

import com.chienle.model.DanhMuc;
import com.chienle.repository.IDanhMucRepository;
import com.chienle.service.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService implements IDanhMucService {
    @Autowired
    private IDanhMucRepository iDanhMucRepository;

    @Override
    public List<DanhMuc> findAll() {
        return iDanhMucRepository.findAll();
    }
}
