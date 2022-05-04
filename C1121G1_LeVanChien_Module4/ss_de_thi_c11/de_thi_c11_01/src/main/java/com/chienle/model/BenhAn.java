package com.chienle.model;

import javax.persistence.*;

@Entity
public class BenhAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBenhAn;

    private String maBenhAn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_benh_nhan", referencedColumnName = "idBenhNhan")
    private BenhNhan benhNhan;

    public BenhAn() {
    }

    public Integer getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(Integer idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }
}
