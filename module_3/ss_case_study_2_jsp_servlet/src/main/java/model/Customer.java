package model;

public class Customer extends Person{
    private String customerCode;
    private Integer customerTypeCode;
    private String address;

    public Customer() {
    }

    public Customer(String customerCode, Integer customerTypeCode, String address) {
        this.customerCode = customerCode;
        this.customerTypeCode = customerTypeCode;
        this.address = address;
    }

    public Customer(String customerCode, String name, String dateOfBirth, Boolean gender, String IDNumber, String phoneNumber, String email, Integer customerTypeCode, String address) {
        super(name, dateOfBirth, gender, IDNumber, phoneNumber, email);
        this.customerCode = customerCode;
        this.customerTypeCode = customerTypeCode;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getStringPerson() {
        return this.customerCode + "," + super.getStringPerson() + "," + this.customerTypeCode + "," + this.address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode=" + customerCode +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", IDNumber=" + IDNumber +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", customerType='" + customerTypeCode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
