package com.chienle.service;

import com.chienle.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBenhAnService {
    List<BenhAn> findAllBenhAn();

    Page<BenhAn> findAllBenhAnPaging(String tenBenhNhan, Pageable pageable);

    BenhAn findById(Integer id);

    void save(BenhAn benhAn);

    void delete(BenhAn benhAn);
}
