package com.chienle.service;

import com.chienle.dto.SoTietKiemDto;
import com.chienle.model.SoTietKiem;

import java.util.List;

public interface ISoTietKiemService {
    List<SoTietKiem> findAll();

    void save(SoTietKiem soTietKiem);

    void edit(SoTietKiem soTietKiem);

    void delete(SoTietKiem soTietKiem);

    SoTietKiem findById(Integer id);

    SoTietKiemDto findByIdDto(Integer id);
}
