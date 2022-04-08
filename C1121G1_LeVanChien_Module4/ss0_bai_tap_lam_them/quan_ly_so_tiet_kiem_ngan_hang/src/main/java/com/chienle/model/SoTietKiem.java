package com.chienle.model;

import javax.persistence.*;

@Entity(name = "so_tiet_kiem")
public class SoTietKiem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "date")
    private String thoiGianBatDauGui;

    private Integer kyHan;

    private Double soTienGui;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_khach_hang",referencedColumnName = "id")
    private KhachHang khachHang;

    public SoTietKiem() {
    }

    public SoTietKiem(Integer id, String thoiGianBatDauGui, Integer kyHan, Double soTienGui, KhachHang khachHang) {
        this.id = id;
        this.thoiGianBatDauGui = thoiGianBatDauGui;
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
        this.khachHang = khachHang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThoiGianBatDauGui() {
        return thoiGianBatDauGui;
    }

    public void setThoiGianBatDauGui(String thoiGianBatDauGui) {
        this.thoiGianBatDauGui = thoiGianBatDauGui;
    }

    public Integer getKyHan() {
        return kyHan;
    }

    public void setKyHan(Integer kyHan) {
        this.kyHan = kyHan;
    }

    public Double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(Double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
