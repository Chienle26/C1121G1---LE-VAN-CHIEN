package com.chienle.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "khach_hang")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ten;

    @OneToMany(mappedBy = "khachHang")
    private Set<SoTietKiem> soTietKiems;

    public KhachHang() {
    }

    public KhachHang(Integer id, String ten, Set<SoTietKiem> soTietKiems) {
        this.id = id;
        this.ten = ten;
        this.soTietKiems = soTietKiems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<SoTietKiem> getSoTietKiems() {
        return soTietKiems;
    }

    public void setSoTietKiems(Set<SoTietKiem> soTietKiems) {
        this.soTietKiems = soTietKiems;
    }
}
