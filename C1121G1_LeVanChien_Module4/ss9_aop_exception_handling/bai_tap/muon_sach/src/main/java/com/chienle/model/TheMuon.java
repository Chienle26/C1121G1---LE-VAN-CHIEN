package com.chienle.model;

import javax.persistence.*;

@Entity
public class TheMuon {
    @Id
    private Integer id;

    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "sach_id",referencedColumnName = "id")
    private Sach sach;

    public TheMuon() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }
}
