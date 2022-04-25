package com.chienle.dto;

import com.chienle.model.contract.Contract;
import com.chienle.model.customer.Customer;
import com.chienle.model.customer.CustomerType;
import com.chienle.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;

public class CustomerDto implements Validator {

    private Integer customerId;

    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Mã khách hàng phải có định dạng KH-XXXX, trong đó X là số tự nhiên.")
    private String customerCode;

    @NotBlank(message = "Tên không được để trống.")
    private String customerName;

    @NotBlank(message = "Ngày sinh không được để trống.")
    private String customerBirthday;

    private Integer customerGender;

    @Pattern(regexp = "^\\d{9}|\\d{11}$", message = "CMND phải có định dạng XXXXXXXXX hoặc XXXXXXXXXXXXXXXX, trong đó X là số tự nhiên.")
    private String customerIdCard;

    @Pattern(regexp = "^((090)|(091)|(\\+8490)|(\\+8491))\\d{7}$", message = "Sai định dạng số điện thoại (090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String customerPhone;

    @NotBlank(message = "Email không được để trống!")
    @Email( message = "Sai định dạng email")
    private String customerEmail;

    @NotBlank(message = "Địa chỉ không được để trống!")
    private String customerAddress;

    private Integer active = 1;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer customerId, String customerCode, String customerName, String customerBirthday, Integer customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, Integer active, CustomerType customerType) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.active = active;
        this.customerType = customerType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        CustomerDto customerDto = (CustomerDto) target;
        String customerCurrentCode = customerDto.getCustomerCode();

//        Customer customer = iCustomerService.findByCode(customerCurrentCode);
//        if (customer != null) {
//            if (customer.getCustomerCode().equals(customerCurrentCode)) {
//                errors.rejectValue("customerCode", "", "Mã khách hàng đã tồn tại.");
//            }
//        }
    }
}
