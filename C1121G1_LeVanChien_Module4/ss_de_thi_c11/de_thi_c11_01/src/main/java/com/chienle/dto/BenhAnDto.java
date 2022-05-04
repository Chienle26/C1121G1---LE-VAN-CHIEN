package com.chienle.dto;

import com.chienle.model.BenhNhan;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

public class BenhAnDto {
    private Integer idBenhAn;

    private String maBenhAn;

    @Valid
    private BenhNhanDto benhNhanDto;

    public BenhAnDto() {
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

    public BenhNhanDto getBenhNhanDto() {
        return benhNhanDto;
    }

    public void setBenhNhanDto(BenhNhanDto benhNhanDto) {
        this.benhNhanDto = benhNhanDto;
    }
}
