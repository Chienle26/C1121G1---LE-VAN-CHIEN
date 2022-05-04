package com.chienle.service;

import com.chienle.dto.KhuyenMaiDto;
import com.chienle.model.KhuyenMai;

import java.util.List;

public interface IKhuyenMaiService {
    List<KhuyenMai> findAll();

//    List<KhuyenMai> search(Double mucGiamGia, String thoiGianBatDau, String thoiGianKetThuc);

    void save(KhuyenMai khuyenMai);

    KhuyenMai findById(Integer id);

    void delete(KhuyenMai khuyenMai);

//    List<KhuyenMai> findByMucGiamGia(Double mucGiamGia);
//
//    List<KhuyenMai> findByThoiGianBatDau(String thoiGianBatDau);
//
//    List<KhuyenMai> findByThoiAndThoiGianKetThuc(String thoiGianKetThuc);
}
