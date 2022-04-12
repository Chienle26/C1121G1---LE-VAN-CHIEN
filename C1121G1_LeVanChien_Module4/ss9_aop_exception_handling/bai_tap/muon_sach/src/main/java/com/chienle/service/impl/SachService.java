package com.chienle.service.impl;

import com.chienle.model.Sach;
import com.chienle.repository.ISachRepository;
import com.chienle.service.ISachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SachService implements ISachService {

    @Autowired
    ISachRepository iSachRepository;

    @Override
    public List<Sach> findAll() {
        return iSachRepository.findAll();
    }

    @Override
    public Sach findById(Integer id) {
        return iSachRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Sach sach) {
        iSachRepository.save(sach);
    }
}
