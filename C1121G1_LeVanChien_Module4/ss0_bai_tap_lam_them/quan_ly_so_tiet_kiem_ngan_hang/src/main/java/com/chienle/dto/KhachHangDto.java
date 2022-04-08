package com.chienle.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class KhachHangDto{

    private Integer id;

    @Pattern(regexp = "[^0-9]+",message = "Tên chưa đúng chuẩn!")
    @NotBlank(message = "Tên không được để trống!")
    private String ten;

    public KhachHangDto() {
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
}
