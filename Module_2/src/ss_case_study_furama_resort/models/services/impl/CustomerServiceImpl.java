package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Customer;
import ss_case_study_furama_resort.models.model.Employee;
import ss_case_study_furama_resort.models.services.ICustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList = new LinkedList<>();

    static {
        customerList.add(new Customer(11111, "Lê Văn Chiến", "1/1/2011", "Nam", 123456789,
                708313527, "chienle@gmail.com", "Diamond", "Đà Nẵng"));
        customerList.add(new Customer(22222, "Lê Văn Chiến2", "1/1/2011", "Nam", 223456789,
                708313527, "chienle@gmail.com", "Diamond", "Đà Nẵng"));
    }

    @Override
    public void add() {
        System.out.print("Nhập mã số khách hàng: ");
        int customerCode = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày tháng năm sinh khách hàng: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Nhập giới tính khách hàng: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập số CMND khách hàng: ");
        int IDNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập SĐT khách hàng: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập email khách hàng: ");
        String email = scanner.nextLine();
        System.out.print("Nhập loại khách hàng: ");
        String customerType = scanner.nextLine();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        customerList.add(new Customer(customerCode, name, dateOfBirth, gender, IDNumber, phoneNumber, email, customerType, address));
        System.err.println("Thêm mới thành công!");
    }

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void edit() {
        System.out.print("Nhập tên khách hàng muốn sửa: ");
        String nameSearch = scanner.nextLine();
        boolean flag = true;
        for (Customer customer : customerList) {
            if (nameSearch.equals(customer.getName())) {
                flag = false;
                System.out.println("Nhập các thông tin cần sửa: ");
                System.out.print("Nhập tên khách hàng: ");
                String name = scanner.nextLine();
                System.out.print("Nhập ngày tháng năm sinh khách hàng: ");
                String dateOfBirth = scanner.nextLine();
                System.out.print("Nhập giới tính khách hàng: ");
                String gender = scanner.nextLine();
                System.out.print("Nhập số CMND khách hàng: ");
                int IDNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập SĐT khách hàng: ");
                int phoneNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập email khách hàng: ");
                String email = scanner.nextLine();
                System.out.print("Nhập loại khách hàng: ");
                String customerType = scanner.nextLine();
                System.out.print("Nhập địa chỉ khách hàng: ");
                String address = scanner.nextLine();
                customer.setName(name);
                customer.setDateOfBirth(dateOfBirth);
                customer.setGender(gender);
                customer.setIDNumber(IDNumber);
                customer.setPhoneNumber(phoneNumber);
                customer.setEmail(email);
                customer.setCustomerType(customerType);
                customer.setAddress(address);
                System.err.println("Sửa đổi mới thành công!");
            }
        }
        if (flag) {
            System.err.println("Tên bạn nhập không tìm thấy!");
        }
    }

    @Override
    public void returnMainMenu() {

    }
}
