package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDto implements Validator {
    private Integer id;

    @NotBlank(message = "Tên không được để trống và không được có khoảng trống")
    @Size(min = 5, max = 45, message = "Tên có tối thiểu 5 ký tự và tối đa 45 ký tự")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Tên không được có số!")
    private String firstName;

    @NotBlank(message = "Họ không được để trống và không được có khoảng trống")
    @Size(min = 5, max = 45, message = "Họ có tối thiểu 5 ký tự và tối đa 45 ký tự")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Họ không được có số!")
    private String lastName;

    @NotBlank(message = "SĐT không được để trống và không được có khoảng trống")
    @Pattern(regexp = "^(090\\d{7})|(091\\d{7})|(\\(\\+84\\)90\\d{7})|(\\(\\+84\\)91\\d{7})$")
    private String phoneNumber;

    @NotBlank(message = "Ngày sinh không được để trống và không được có khoảng trống")
    @Column(columnDefinition = "date")
    private String dateOfBirth;

    @NotBlank(message = "Email không được để trống và không được có khoảng trống")
    @Email(message = "Email phải đúng chuẩn email quốc tế")
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        System.out.println(userDto.dateOfBirth);
        Integer yearBirth = Integer.valueOf(userDto.dateOfBirth.substring(0,4));
        Integer yearCurrent = LocalDate.now().getYear();
        if (yearCurrent - yearBirth <18){
            errors.rejectValue("dateOfBirth","std.not18","Chưa đủ 18 tuổi!");
        }
    }
}
