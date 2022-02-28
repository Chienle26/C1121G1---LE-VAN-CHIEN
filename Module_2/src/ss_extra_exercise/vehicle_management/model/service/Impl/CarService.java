package ss_extra_exercise.vehicle_management.model.service.Impl;

import ss_extra_exercise.vehicle_management.model.model.Car;
import ss_extra_exercise.vehicle_management.model.service.ICarService;
import ss_extra_exercise.vehicle_management.model.model.ListBrandName;

import java.util.ArrayList;
import java.util.Scanner;

public class CarService implements ICarService {
    private static ArrayList<Car> car = new ArrayList<>();
    static {
        car.add(new Car("43A-212.56","Toyata",2019,"Du lịch","Nguyễn Văn A",5));
        car.add(new Car("43B-453.88","Huyndai",2020,"Xe khách","Nguyễn Văn B",45));
        car.add(new Car("43B-453.89","Ford",2020,"Xe khách","Nguyễn Văn C",16));
    }

    @Override
    public void displayCar() {
        for (Car element : car) {
            System.out.println(element);
        }
    }

    @Override
    public void addCar() {
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
        System.out.println("Nhập chủ kiểu xe: ");
        String vehicleType = scanner.nextLine();
        System.out.println("Nhập số chỗ ngồi: ");
        Integer numberOfSeat = Integer.parseInt(scanner.nextLine());
        car.add(new Car(lisencePlates,brandName,yearOfManufacture,vehicleType,owner,numberOfSeat));
        System.err.println("Thêm mới hành công!");
    }
}
