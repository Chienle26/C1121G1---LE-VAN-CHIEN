package model;

public class Customer extends Person{
    private String customerCode;
    private Integer customerTypeCode;
    private Boolean gender;

    public Customer() {
    }

    public Customer(String customerCode, Integer customerTypeCode, Boolean gender) {
        this.customerCode = customerCode;
        this.customerTypeCode = customerTypeCode;
        this.gender = gender;
    }

    public Customer(String name, String dateOfBirth, String IDNumber, String phoneNumber, String email, String address, String customerCode, Integer customerTypeCode, Boolean gender) {
        super(name, dateOfBirth, IDNumber, phoneNumber, email, address);
        this.customerCode = customerCode;
        this.customerTypeCode = customerTypeCode;
        this.gender = gender;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getCustomerTypeCode() {
        return customerTypeCode;
    }

    public void setCustomerTypeCode(Integer customerTypeCode) {
        this.customerTypeCode = customerTypeCode;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode='" + customerCode + '\'' +
                ", customerTypeCode=" + customerTypeCode +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", IDNumber='" + IDNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
