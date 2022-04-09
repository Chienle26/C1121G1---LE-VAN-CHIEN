package com.chienle.service.impl;

import com.chienle.dto.SoTietKiemDto;
import com.chienle.model.SoTietKiem;
import com.chienle.repository.ISoTietKiemRepository;
import com.chienle.service.ISoTietKiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoTietKiemService implements ISoTietKiemService {

    @Autowired
    ISoTietKiemRepository iSoTietKiemRepository;

    @Override
    public List<SoTietKiem> findAll() {
        return iSoTietKiemRepository.findAll();
    }

    @Override
    public void save(SoTietKiem soTietKiem) {
        iSoTietKiemRepository.save(soTietKiem);
    }

    @Override
    public void edit(SoTietKiem soTietKiem) {
        iSoTietKiemRepository.save(soTietKiem);
    }

    @Override
    public void delete(SoTietKiem soTietKiem) {
        iSoTietKiemRepository.delete(soTietKiem);
    }

    @Override
    public SoTietKiem findById(Integer id) {
        return iSoTietKiemRepository.findById(id).orElse(null);
    }

    @Override
    public List<SoTietKiem> findByName(String name) {
        return iSoTietKiemRepository.findAllByKhachHang_TenContaining(name);
    }


}
