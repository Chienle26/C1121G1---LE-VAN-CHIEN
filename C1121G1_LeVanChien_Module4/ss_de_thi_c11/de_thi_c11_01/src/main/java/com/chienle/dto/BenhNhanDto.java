package com.chienle.dto;

import com.chienle.model.BenhAn;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

public class BenhNhanDto implements Validator {
    private Integer idBenhNhan;

    private String maBenhNhan;

    @Pattern(regexp = "[^0-9]")
    private String tenBenhNhan;

    private String ngayNhapVien;

    private String ngayRaVien;

    private String lyDoNhapVien;

    public BenhNhanDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BenhNhanDto benhNhanDto = (BenhNhanDto) target;
        final String REGEX_DATE = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        if (!benhNhanDto.getNgayNhapVien().matches(REGEX_DATE) && benhNhanDto.getNgayRaVien().matches(REGEX_DATE)) {
            errors.rejectValue("ngayNhapVien", "", "Nhập sai định dạng!");
            errors.rejectValue("ngayRaVien", "", "Nhập sai định dạng!");
        } else {
//          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ngayNhapVien = LocalDate.parse(benhNhanDto.getNgayNhapVien());
            LocalDate ngayRaVien = LocalDate.parse(benhNhanDto.getNgayRaVien());
//          LocalDate thoiGianChon = LocalDate.parse(customerDto.getCustomerBirthday(),formatter);

            if (ngayRaVien.isBefore(ngayNhapVien)) {
                errors.rejectValue("ngayRaVien", "", "Ngày ra viện không được trước ngày nhập viện!");
            }
        }
    }
}
