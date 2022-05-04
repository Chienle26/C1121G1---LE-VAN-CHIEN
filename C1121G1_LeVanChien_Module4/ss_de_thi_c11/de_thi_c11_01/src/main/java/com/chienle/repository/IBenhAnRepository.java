package com.chienle.repository;

import com.chienle.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBenhAnRepository extends JpaRepository<BenhAn, Integer> {
    Page<BenhAn> findByBenhNhan_TenBenhNhanContaining(String tenBenhNhan, Pageable pageable);
}
