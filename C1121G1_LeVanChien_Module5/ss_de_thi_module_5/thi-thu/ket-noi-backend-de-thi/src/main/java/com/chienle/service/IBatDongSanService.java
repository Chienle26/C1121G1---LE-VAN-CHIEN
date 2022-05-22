package com.chienle.service;

import com.chienle.model.BatDongSan;

import java.util.List;

public interface IBatDongSanService {
    List<BatDongSan> findAll();


    void create(BatDongSan batDongSan);

    BatDongSan findById(Integer id);

    void delete(Integer id);
}
