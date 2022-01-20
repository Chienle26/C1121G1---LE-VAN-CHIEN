package ss_extra_exercise.vehicle_management.model.model;

import java.util.ArrayList;

public class ListBrandName {
    String manufactureCode;
    String brandName;
    String Country;

    public ListBrandName() {
    }

    public ListBrandName(String manufactureCode, String brandName, String country) {
        this.manufactureCode = manufactureCode;
        this.brandName = brandName;
        Country = country;
    }

    public String getManufactureCode() {
        return manufactureCode;
    }

    public void setManufactureCode(String manufactureCode) {
        this.manufactureCode = manufactureCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "ListBrandName{" +
                "manufactureCode='" + manufactureCode + '\'' +
                ", brandName='" + brandName + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }

}
