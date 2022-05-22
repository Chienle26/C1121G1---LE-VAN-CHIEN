package com.chienle.repository;

import com.chienle.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDanhMucRepository extends JpaRepository<DanhMuc, Integer> {
}
