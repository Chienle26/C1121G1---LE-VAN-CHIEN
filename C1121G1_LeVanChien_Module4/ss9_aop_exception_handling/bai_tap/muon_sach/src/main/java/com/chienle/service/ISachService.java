package com.chienle.service;

import com.chienle.model.Sach;

import java.util.List;

public interface ISachService {
    List<Sach> findAll();

    Sach findById(Integer id);

    void save(Sach sach);
}
