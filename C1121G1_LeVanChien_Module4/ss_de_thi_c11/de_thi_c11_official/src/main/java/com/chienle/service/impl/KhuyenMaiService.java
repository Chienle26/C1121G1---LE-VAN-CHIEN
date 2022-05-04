package com.chienle.service.impl;

import com.chienle.model.KhuyenMai;
import com.chienle.repository.IKhuyenMaiRepository;
import com.chienle.service.IKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiService implements IKhuyenMaiService {
    @Autowired
    private IKhuyenMaiRepository iKhuyenMaiRepository;

    @Override
    public List<KhuyenMai> findAll() {
        return iKhuyenMaiRepository.findAll();
    }


    @Override
    public void save(KhuyenMai khuyenMai) {
        iKhuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public KhuyenMai findById(Integer id) {
        return iKhuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(KhuyenMai khuyenMai) {
        iKhuyenMaiRepository.delete(khuyenMai);
    }

//    @Override
//    public List<KhuyenMai> findByMucGiamGia(Double mucGiamGia) {
//        return iKhuyenMaiRepository.findByMucGiamGiaGreaterThanEqual(mucGiamGia);
//    }
//
//    @Override
//    public List<KhuyenMai> findByThoiGianBatDau(String thoiGianBatDau) {
//        return iKhuyenMaiRepository.findByThoiGianBatDauAfter(thoiGianBatDau);
//    }
//
//    @Override
//    public List<KhuyenMai> findByThoiAndThoiGianKetThuc(String thoiGianKetThuc) {
//        return iKhuyenMaiRepository.findByThoiAndThoiGianKetThucBefore(thoiGianKetThuc);
//    }
}
