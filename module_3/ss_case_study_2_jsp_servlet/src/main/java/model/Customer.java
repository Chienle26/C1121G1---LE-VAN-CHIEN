package model;

public class Customer extends Person{
    private Integer customerCode;
    private Integer customerType;
    private String address;

    public Customer() {
    }

    public Customer(Integer customerCode, Integer customerType, String address) {
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(Integer customerCode, String name, String dateOfBirth, Boolean gender, String IDNumber, String phoneNumber, String email, Integer customerType, String address) {
        super(name, dateOfBirth, gender, IDNumber, phoneNumber, email);
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public Integer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Integer customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getStringPerson() {
        return this.customerCode + "," + super.getStringPerson() + "," + this.customerType + "," + this.address;
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
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
