package ss_extra_exercise.vehicle_management.model.service.Impl;

import ss_extra_exercise.vehicle_management.model.model.Truck;
import ss_extra_exercise.vehicle_management.model.service.ITruckService;
import ss_extra_exercise.vehicle_management.util.ListBrandName;

import java.util.ArrayList;
import java.util.Scanner;

public class TruckService implements ITruckService {
    private static ArrayList<Truck> truck = new ArrayList<>();

    static {
        truck.add(new Truck("43C-01.234", "Huyndai", 2019, "Nguyễn Văn A", 3));
        truck.add(new Truck("43C-47.678", "Dongfeng", 2020, "Nguyễn Văn B", 9));
        truck.add(new Truck("43C-45.235", "Hino", 2021, "Nguyễn Văn C", 12));
    }


    @Override
    public void displayTruck() {
        for (Truck element : truck) {
            System.out.println(element);
        }
    }

    @Override
    public void addTruck() {
        ListBrandName listBrandName = new ListBrandName();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Biển kiểm soát: ");
        String lisencePlates = scanner.nextLine();
        System.out.println("Nhập hãng sản xuất: (1->7) ");
        listBrandName.displayListBrandName();
        Integer index = Integer.parseInt(scanner.nextLine());
        String brandName = listBrandName.arrayListBrandName.get(index - 1).getBrandName();
        System.out.println("Nhập năm sản xuất: ");
        Integer yearOfManufacture = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.println("Nhập tải trọng: ");
        Integer weight = Integer.parseInt(scanner.nextLine());
        truck.add(new Truck(lisencePlates, brandName, yearOfManufacture, owner, weight));
        System.err.println("Thêm mới hành công!");
    }
}
