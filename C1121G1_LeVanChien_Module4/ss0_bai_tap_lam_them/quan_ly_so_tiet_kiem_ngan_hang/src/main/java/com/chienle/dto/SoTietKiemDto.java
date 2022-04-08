package com.chienle.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sun.util.calendar.BaseCalendar;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class SoTietKiemDto implements Validator {
    private Integer id;

    private String thoiGianBatDauGui;

    @NotNull(message = "Kỳ hạn không được để trống!")
    private Integer kyHan;

    @NotNull(message = "Số tiền gửi không được để trống!")
    private Double soTienGui;

    @Valid
    private KhachHangDto khachHangDto;

    public SoTietKiemDto() {
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

    public KhachHangDto getKhachHangDto() {
        return khachHangDto;
    }

    public void setKhachHangDto(KhachHangDto khachHangDto) {
        this.khachHangDto = khachHangDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SoTietKiemDto soTietKiemDto = (SoTietKiemDto) target;

        if (soTietKiemDto.getThoiGianBatDauGui().isEmpty()){
            errors.rejectValue("thoiGianBatDauGui", "stk.notTime", "Vui lòng nhập thời gian!");
        } else {
            LocalDate thoiGianHienTai = LocalDate.now();
            LocalDate thoiGianGuiTietkiem = LocalDate.parse(soTietKiemDto.getThoiGianBatDauGui());

            if (thoiGianGuiTietkiem.isBefore(thoiGianHienTai)) {
                errors.rejectValue("thoiGianBatDauGui", "stk.notBeforeDateCurrent", "Ngày gửi tiết kiệm không được trước ngày hôm nay!");
            }

            if (soTietKiemDto.getSoTienGui() <= 30000000) {
                errors.rejectValue("soTienGui", "stk.not30000000", "Số tiền gửi không được để trống và phải lớn hơn 30000000!");
            }

            if (soTietKiemDto.getKyHan() <= 0) {
                errors.rejectValue("kyHan", "stk.notZero", "Kỳ hạn gửi không được để trống và phải lớn hơn 0!");
            }
        }
    }
}
