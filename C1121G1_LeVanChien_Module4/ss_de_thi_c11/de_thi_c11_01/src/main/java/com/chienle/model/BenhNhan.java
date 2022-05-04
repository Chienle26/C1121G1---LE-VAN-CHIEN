package com.chienle.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BenhNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBenhNhan;

    private String maBenhNhan;

    private String tenBenhNhan;

    @Column(columnDefinition = "date")
    private String ngayNhapVien;

    @Column(columnDefinition = "date")
    private String ngayRaVien;

    private String lyDoNhapVien;

    @OneToMany(mappedBy = "benhNhan")
    private Set<BenhAn> benhAns;

    public BenhNhan() {
    }

    public Integer getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(Integer idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public Set<BenhAn> getBenhAns() {
        return benhAns;
    }

    public void setBenhAns(Set<BenhAn> benhAns) {
        this.benhAns = benhAns;
    }
}
