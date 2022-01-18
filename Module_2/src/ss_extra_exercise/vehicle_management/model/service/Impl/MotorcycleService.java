package ss_extra_exercise.vehicle_management.model.service.Impl;

import ss_extra_exercise.vehicle_management.model.model.Motorcycle;
import ss_extra_exercise.vehicle_management.model.model.Truck;
import ss_extra_exercise.vehicle_management.model.service.IMotorcycleService;
import ss_extra_exercise.vehicle_management.util.ListBrandName;

import java.util.ArrayList;
import java.util.Scanner;

public class MotorcycleService implements IMotorcycleService {
    private static ArrayList<Motorcycle> motorcycle = new ArrayList<>();

    static {
        motorcycle.add(new Motorcycle("43-K1-678.56", "Yamaha", 2019, "Nguyễn Văn A", 100));
        motorcycle.add(new Motorcycle("43-H1-345.89", "Honda", 2019, "Nguyễn Văn B", 150));
        motorcycle.add(new Motorcycle("43-AK-765.23", "Yamaha", 2019, "Nguyễn Văn C", 50));
    }

    @Override
    public void displayMotorcycle() {
        for (Motorcycle element : motorcycle) {
            System.out.println(element);
        }
    }

    @Override
    public void addMotorcycle() {
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
        System.out.println("Nhập công suất: ");
        Integer capacity = Integer.parseInt(scanner.nextLine());
        motorcycle.add(new Motorcycle(lisencePlates, brandName, yearOfManufacture, owner, capacity));
        System.err.println("Thêm mới hành công!");
    }
}
