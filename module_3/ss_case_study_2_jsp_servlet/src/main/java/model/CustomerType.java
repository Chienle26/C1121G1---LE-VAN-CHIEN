package model;

public class CustomerType {
    private Integer customerTypeCode;
    private String customerTypeName;

    public CustomerType(Integer customerTypeCode, String customerTypeName) {
        this.customerTypeCode = customerTypeCode;
        this.customerTypeName = customerTypeName;
    }

    public Integer getCustomerTypeCode() {
        return customerTypeCode;
    }

    public void setCustomerTypeCode(Integer customerTypeCode) {
        this.customerTypeCode = customerTypeCode;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "customerTypeId=" + customerTypeCode +
                ", customerTypeName='" + customerTypeName + '\'' +
                '}';
    }
}
