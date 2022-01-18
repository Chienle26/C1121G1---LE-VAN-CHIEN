package ss_extra_exercise.vehicle_management.util;

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

    public static ArrayList<ListBrandName> arrayListBrandName = new ArrayList<>();
    static {
        arrayListBrandName.add(new ListBrandName("HSX-001","Yamaha","Nhật Bản"));
        arrayListBrandName.add(new ListBrandName("HSX-002","Honda","Nhật Bản"));
        arrayListBrandName.add(new ListBrandName("HSX-003","Dongfeng","Trung Quốc"));
        arrayListBrandName.add(new ListBrandName("HSX-004","Huyndai","Hàn Quốc"));
        arrayListBrandName.add(new ListBrandName("HSX-005","Ford","Mỹ"));
        arrayListBrandName.add(new ListBrandName("HSX-006","Toyota","Nhật Bản"));
        arrayListBrandName.add(new ListBrandName("HSX-007","Hino","Nhật Bản"));
    }

    public void displayListBrandName(){
        for (ListBrandName element: arrayListBrandName){
            System.out.println(element);
        }
    }
}
