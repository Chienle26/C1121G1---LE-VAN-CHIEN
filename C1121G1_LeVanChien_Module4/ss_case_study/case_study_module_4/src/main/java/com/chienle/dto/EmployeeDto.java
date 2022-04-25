package com.chienle.dto;

import com.chienle.model.employee.Division;
import com.chienle.model.employee.EducationDegree;
import com.chienle.model.employee.Position;
import com.chienle.model.user_role.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeeDto {

    private Integer employeeId;

    @NotBlank(message = "Tên không được để trống.")
    private String employeeName;

    @NotBlank(message = "Ngày sinh không được để trống.")
    private String employeeBirthday;

    @Pattern(regexp = "^\\d{9}|\\d{11}$", message = "CMND phải có định dạng XXXXXXXXX hoặc XXXXXXXXXXXXXXXX, trong đó X là số tự nhiên.")
    private String employeeIdCard;

//    @NotBlank(message = "Lương không được để trống!")
    @Min(value = 0, message = "Lương phải là số dương.")
    private Double employeeSalary;

    @Pattern(regexp = "^((090)|(091)|(\\+8490)|(\\+8491))\\d{7}$", message = "Sai định dạng số điện thoại (090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String employeePhone;

    @NotBlank(message = "Email không được để trống!")
    @Email( message = "Sai định dạng email")
    private String employeeEmail;

    @NotBlank(message = "Địa chỉ không được để trống!")
    private String employeeAddress;

    private Integer active = 1;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

//    @NotBlank(message = "User không được để trống!")
    private User user;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer employeeId, String employeeName, String employeeBirthday, String employeeIdCard, Double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Integer active, Position position, EducationDegree educationDegree, Division division, User user) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.active = active;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
