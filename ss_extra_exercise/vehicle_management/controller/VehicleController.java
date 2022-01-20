package ss_extra_exercise.vehicle_management.controller;

import ss_extra_exercise.vehicle_management.model.service.ICarService;
import ss_extra_exercise.vehicle_management.model.service.IMotorcycleService;
import ss_extra_exercise.vehicle_management.model.service.ITruckService;
import ss_extra_exercise.vehicle_management.model.service.Impl.CarService;
import ss_extra_exercise.vehicle_management.model.service.Impl.MotorcycleService;
import ss_extra_exercise.vehicle_management.model.service.Impl.TruckService;

import java.util.Scanner;

public class VehicleController {
    public static void main(String[] args) {
        ITruckService iTruckService = new TruckService();
        ICarService iCarService = new CarService();
        IMotorcycleService iMotorcycleService = new MotorcycleService();
        boolean check = true;
        while (check) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG: ");
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm mới phương tiện.");
            System.out.println("2. Hiển thị phương tiện.");
            System.out.println("3. Xóa phương tiện.");
            System.out.println("4. Thoát.");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("1. Thêm xe tải.");
                    System.out.println("2. Thêm xe ôtô.");
                    System.out.println("3. Thêm xe máy.");
                    int chooseAdd = Integer.parseInt(scanner.nextLine());
                    switch (chooseAdd) {
                        case 1:
                            iTruckService.addTruck();
                            break;
                        case 2:
                            iCarService.addCar();
                            break;
                        case 3:
                            iMotorcycleService.addMotorcycle();
                            break;
                        default:
                            System.out.println("Mời bạn chọn lại!");
                    }
                    break;
                case 2:
                    System.out.println("1. Hiển thị xe tải.");
                    System.out.println("2. Hiển thị xe ôtô.");
                    System.out.println("3. Hiển thị xe máy.");
                    int chooseDisplay = Integer.parseInt(scanner.nextLine());
                    switch (chooseDisplay) {
                        case 1:
                            iTruckService.displayTruck();
                            break;
                        case 2:
                            iCarService.displayCar();
                            break;
                        case 3:
                            iMotorcycleService.displayMotorcycle();
                            break;
                        default:
                            System.out.println("Mời bạn chọn lại!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập biển kiểm soát xe cần xóa: ");
                    String licencePlates = scanner.nextLine();

                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("Mời bạn chọn lại!");
            }
        }

    }

    private static void truckDisplay() {
    }

}
