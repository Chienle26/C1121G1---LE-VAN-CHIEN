package com.chienle.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class KhuyenMaiDto implements Validator {
    private Integer id;

    @NotBlank(message = "Tiêu đề không được để trống!")
    private String tieuDe;

    @NotBlank(message = "Thời gian bắt đầu không được để trống!")
    private String thoiGianBatDau;

    @NotBlank(message = "Thời gian kết thúc không được để trống!")
    private String thoiGianKetThuc;

    @NotNull(message = "Mức giá không được để trống!")
    @Min(value = 10000, message = "Mức giảm giá phải lớn hơn 10.000!")
    private Double mucGiamGia;

    @NotBlank(message = "Chi tiết không được để trống!")
    private String chiTiet;

    public KhuyenMaiDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public Double getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(Double mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        KhuyenMaiDto khuyenMaiDto = (KhuyenMaiDto) target;
        final String REGEX_DATE = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        if (!(khuyenMaiDto.getThoiGianBatDau().matches(REGEX_DATE) && khuyenMaiDto.getThoiGianKetThuc().matches(REGEX_DATE))) {
            errors.rejectValue("thoiGianBatDau", "", "Nhập sai định dạng ngày tháng!");
            errors.rejectValue("thoiGianKetThuc", "", "Nhập sai định dạng ngày tháng!");
        } else {
//          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate thoiGianHienTai = LocalDate.now();
            LocalDate thoiGianBatDau = LocalDate.parse(khuyenMaiDto.getThoiGianBatDau());
            LocalDate thoiGianKetThuc = LocalDate.parse(khuyenMaiDto.getThoiGianKetThuc());
//          LocalDate thoiGianChon = LocalDate.parse(customerDto.getCustomerBirthday(),formatter);

            if (thoiGianBatDau.isBefore(thoiGianHienTai)) {
                errors.rejectValue("thoiGianBatDau", "", "Thời gian bắt đầu không được trước thời gian hiện tại!");
            }

            if (!(thoiGianKetThuc.compareTo(thoiGianBatDau) >= 1)){
                errors.rejectValue("thoiGianKetThuc", "", "Thời gian kết thúc phải sau thời gian bắt đầu 1 ngày!");
            }
        }
    }
}
