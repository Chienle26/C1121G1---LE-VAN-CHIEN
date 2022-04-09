package com.chienle.repository;

import com.chienle.model.SoTietKiem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISoTietKiemRepository extends JpaRepository<SoTietKiem, Integer> {

    List<SoTietKiem> findAllByKhachHang_TenContaining(String name);

}
