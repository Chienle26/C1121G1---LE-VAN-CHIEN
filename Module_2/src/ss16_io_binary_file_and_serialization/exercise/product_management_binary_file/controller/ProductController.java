package ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.controller;

import ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.model.service.ISmartphoneService;
import ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.model.service.impl.SmartphoneService;

import java.util.Scanner;

public class ProductController {
    public static void main(String[] args) {
        ISmartphoneService iSmartphoneService = new SmartphoneService();
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu quản lý sản phẩm: \n" +
                    "1. Thêm mới sản phẩm. \n" +
                    "2. Hiển thị danh sách sản phẩm. \n" +
                    "3. Tìm kiếm sản phẩm. \n" +
                    "4. Thoát.");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iSmartphoneService.add();
                    break;
                case 2:
                    iSmartphoneService.display();
                    break;
                case 3:
                    iSmartphoneService.search();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn lại!");
            }
        }
    }
}
