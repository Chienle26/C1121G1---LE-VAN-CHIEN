package ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.model.service.impl;

import ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.model.model.SmartPhone;
import ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.model.service.ISmartphoneService;
import ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.util.ReadFromBinaryFile;
import ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.util.WriteToBinaryFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartphoneService implements ISmartphoneService {
    private static final String SMARTPHONE_PATH_FILE_DAT = "src/ss16_io_binary_file_and_serialization/exercise/product_management_binary_file/data/Smartphone.dat";

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm: ");
        String code = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String brand = scanner.nextLine();
        System.out.print("Nhập dunng lượng bộ nhớ: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập giá sản phẩm: ");
        int price = Integer.parseInt(scanner.nextLine());
        SmartPhone smartPhone = new SmartPhone(code, name, brand, capacity, price);
        List<SmartPhone> smartPhoneList = ReadFromBinaryFile.readBinaryFile(SMARTPHONE_PATH_FILE_DAT);
        smartPhoneList.add(smartPhone);
        WriteToBinaryFile.writeBinaryFile(smartPhoneList, SMARTPHONE_PATH_FILE_DAT);
    }

    @Override
    public void display() {
        System.out.println("Danh sách điện thoại: ");
        List<SmartPhone> smartPhoneList = ReadFromBinaryFile.readBinaryFile(SMARTPHONE_PATH_FILE_DAT);
        for (SmartPhone element : smartPhoneList) {
            System.out.println(element.toString());
        }
    }

    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        List<SmartPhone> smartPhoneList = ReadFromBinaryFile.readBinaryFile(SMARTPHONE_PATH_FILE_DAT);
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String nameSearch = scanner.nextLine();
        for (SmartPhone element : smartPhoneList) {
            if (element.getName().equals(nameSearch)){
                System.out.println(element.toString());
            }
        }
    }
}
