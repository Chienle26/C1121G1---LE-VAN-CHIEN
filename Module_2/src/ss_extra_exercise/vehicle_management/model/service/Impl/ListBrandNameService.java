package ss_extra_exercise.vehicle_management.model.service.Impl;

import ss_extra_exercise.vehicle_management.model.model.ListBrandName;
import ss_extra_exercise.vehicle_management.model.service.IListBrandNameService;

import java.util.ArrayList;

public class ListBrandNameService implements IListBrandNameService {
    public  static  ArrayList<ListBrandName> arrayListBrandName = new ArrayList<>();

    static {
        arrayListBrandName.add(new ListBrandName("HSX-001","Yamaha","Nhật Bản"));
        arrayListBrandName.add(new ListBrandName("HSX-002","Honda","Nhật Bản"));
        arrayListBrandName.add(new ListBrandName("HSX-003","Dongfeng","Trung Quốc"));
        arrayListBrandName.add(new ListBrandName("HSX-004","Huyndai","Hàn Quốc"));
        arrayListBrandName.add(new ListBrandName("HSX-005","Ford","Mỹ"));
        arrayListBrandName.add(new ListBrandName("HSX-006","Toyota","Nhật Bản"));
        arrayListBrandName.add(new ListBrandName("HSX-007","Hino","Nhật Bản"));
    }

    @Override
   public void displayListBrandName() {
        for (ListBrandName element: arrayListBrandName){
            System.out.println(element);
        }
    }
}
