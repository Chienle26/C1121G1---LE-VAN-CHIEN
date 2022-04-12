package com.chienle.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Sach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tenSach;

    private String tacGia;

    private String moTa;

    private Integer soLuong;

    @OneToMany (mappedBy = "sach")
    private Set<TheMuon> theMuons;

    public Sach() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Set<TheMuon> getTheMuons() {
        return theMuons;
    }

    public void setTheMuons(Set<TheMuon> theMuons) {
        this.theMuons = theMuons;
    }
}
