package ss_extra_exercise.vehicle_management.controller;

import ss_extra_exercise.vehicle_management.model.service.IMotorcycleService;
import ss_extra_exercise.vehicle_management.model.service.Impl.MotorcycleService;

import java.util.Scanner;

public class VehicleController {
    public static void main(String[] args) {
//        IMotorcycleService iMotorcycleService = new MotorcycleService();
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG: ");
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm mới phương tiện.");
            System.out.println("2. Hiển thị phương tiện.");
            System.out.println("3. Xóa phương tiện.");
            System.out.println("4. Thoát.");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    System.out.println("1. Thêm xe tải.");
                    System.out.println("2. Thêm xe ôtô.");
                    System.out.println("3. Thêm xe máy.");
                    int chooseAdd = Integer.parseInt(scanner.nextLine());
//                    switch (chooseAdd){
//                        case 1:
//                            struckAdd();
//                            break;
//                        case 2:
//                            carAdd();
//                            break;
//                        case 3:
//                            motorcycleAdd();
//                            break;
//                        default:
//                            System.out.println("Mời bạn chọn lại!");
//                    }
                    break;
                case 2:
                case 3:
                case 4:
                default:
                    System.out.println("Mời bạn chọn lại!");
            }
        }

    }
}
