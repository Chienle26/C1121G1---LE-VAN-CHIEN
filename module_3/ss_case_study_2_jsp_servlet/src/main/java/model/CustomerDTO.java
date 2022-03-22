package model;

public class CustomerDTO extends Customer{
    private String customerTypeName;

    public CustomerDTO(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public CustomerDTO(String customerCode, Integer customerTypeCode, Boolean gender, String customerTypeName) {
        super(customerCode, customerTypeCode, gender);
        this.customerTypeName = customerTypeName;
    }

    public CustomerDTO(String name, String dateOfBirth, String IDNumber, String phoneNumber, String email, String address, String customerCode, Integer customerTypeCode, Boolean gender, String customerTypeName) {
        super(name, dateOfBirth, IDNumber, phoneNumber, email, address, customerCode, customerTypeCode, gender);
        this.customerTypeName = customerTypeName;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerTypeName='" + customerTypeName + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", IDNumber='" + IDNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
