package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Customer;
import ss_case_study_furama_resort.models.model.Employee;
import ss_case_study_furama_resort.models.services.ICustomerService;
import ss_case_study_furama_resort.utils.ReadAndWriteFileCSV;
import ss_case_study_furama_resort.utils.RegexData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    Scanner scanner = new Scanner(System.in);
    List<Customer> customerList = new LinkedList<>();
    ReadAndWriteFileCSV readAndWriteFileCSV = new ReadAndWriteFileCSV();
    String pathFileCustomer = "src/ss_case_study_furama_resort/data/Customer.csv";

    @Override
    public void add() {
        System.out.print("Nhập mã số khách hàng: ");
        String customerCode = scanner.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày tháng năm sinh khách hàng: ");
        String dateOfBirth = RegexData.regexAge(scanner.nextLine(),RegexData.REGEX_BIRTHDAY);
        System.out.print("Nhập giới tính khách hàng: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập số CMND khách hàng: ");
        String IDNumber = scanner.nextLine();
        System.out.print("Nhập SĐT khách hàng: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập email khách hàng: ");
        String email = scanner.nextLine();
        System.out.print("Nhập loại khách hàng: ");
        String customerType = scanner.nextLine();
        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        customerList = new ArrayList<>();
        customerList.add(new Customer(customerCode, name, dateOfBirth, gender, IDNumber, phoneNumber, email, customerType, address));
        List<String> list = readAndWriteFileCSV.changeToStringList(customerList);
        readAndWriteFileCSV.writeFileCSV(pathFileCustomer,list,true);
        System.err.println("Thêm mới thành công!");
    }

    @Override
    public void display() {
        List<String> list = readAndWriteFileCSV.readFileCSV(pathFileCustomer);
        String[] array;
        for (String element : list){
            array = element.split(",");
            Customer customer = new Customer(array[0], array[1], array[2], array[3], array[4],array[5], array[6], array[7], array[8]);
            System.out.println(customer);
        }
    }

    @Override
    public void edit() {
        List<Customer> customerList2 = new ArrayList<>();
        List<String> listTemp = readAndWriteFileCSV.readFileCSV(pathFileCustomer);
        String[] array;
        for (String element : listTemp){
            array = element.split(",");
            Customer customer = new Customer(array[0], array[1], array[2], array[3], array[4],array[5], array[6], array[7], array[8]);
            customerList2.add(customer);
        }
        System.out.print("Nhập tên khách hàng muốn sửa: ");
        String nameSearch = scanner.nextLine();
        boolean flag = true;
        for (Customer customer : customerList2) {
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
                String IDNumber = scanner.nextLine();
                System.out.print("Nhập SĐT khách hàng: ");
                String phoneNumber = scanner.nextLine();
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
                List<String> list = readAndWriteFileCSV.changeToStringList(customerList2);
                readAndWriteFileCSV.writeFileCSV(pathFileCustomer,list,false);
                System.out.println("Sửa đổi mới thành công!");
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
