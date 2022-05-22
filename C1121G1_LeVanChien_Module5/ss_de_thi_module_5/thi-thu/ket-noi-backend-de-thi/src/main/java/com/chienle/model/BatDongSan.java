package com.chienle.model;

import javax.persistence.*;

@Entity
public class BatDongSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String vungMien;
    private String banLa;
    private String dangTin;
    private String tinhTrang;
    private String diaChi;
    private Integer dienTich;
    private String huong;
    private String tuaDe;
    private String noiDung;
    private Integer gia;
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "danh_muc_id", referencedColumnName = "id")
    private DanhMuc danhMuc;

    public BatDongSan() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVungMien() {
        return vungMien;
    }

    public void setVungMien(String vungMien) {
        this.vungMien = vungMien;
    }

    public String getBanLa() {
        return banLa;
    }

    public void setBanLa(String banLa) {
        this.banLa = banLa;
    }

    public String getDangTin() {
        return dangTin;
    }

    public void setDangTin(String dangTin) {
        this.dangTin = dangTin;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getDienTich() {
        return dienTich;
    }

    public void setDienTich(Integer dienTich) {
        this.dienTich = dienTich;
    }

    public String getHuong() {
        return huong;
    }

    public void setHuong(String huong) {
        this.huong = huong;
    }

    public String getTuaDe() {
        return tuaDe;
    }

    public void setTuaDe(String tuaDe) {
        this.tuaDe = tuaDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
