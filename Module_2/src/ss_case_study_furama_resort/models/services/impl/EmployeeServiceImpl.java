package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Employee;
import ss_case_study_furama_resort.models.services.IEmployeeService;
import ss_case_study_furama_resort.utils.ReadAndWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);
    String pathFileEmloyee = "src/ss_case_study_furama_resort/data/Employee.csv";
    static List<Employee> employeeList = new ArrayList<>();
    static {
        employeeList.add(new Employee(11111, "Lê Văn Chiến", "1/1/2011", "Nam", 123456789,
                708313527, "chienle@gmail.com", "Đại học", "Web Dev", 1000));
        employeeList.add(new Employee(22222, "Lê Văn Chiến2", "1/1/2011", "Nam", 123456789,
                708313527, "chienle@gmail.com", "Đại học", "Web Dev", 1000));
    }

    @Override
    public void add()  {
        try {
            System.out.print("Nhập mã số nhân viên: ");
            int employeeCode = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập tên nhân viên: ");
            String name = scanner.nextLine();
            System.out.print("Nhập ngày tháng năm sinh nhân viên: ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Nhập giới tính nhân viên: ");
            String gender = scanner.nextLine();
            System.out.print("Nhập số CMND nhân viên: ");
            int IDNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập SĐT nhân viên: ");
            int phoneNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập email nhân viên: ");
            String email = scanner.nextLine();
            System.out.print("Nhập bằng cấp nhân viên: ");
            String degree = scanner.nextLine();
            System.out.print("Nhập vị trí nhân viên: ");
            String position = scanner.nextLine();
            System.out.print("Nhập lương nhân viên: ");
            int salary = Integer.parseInt(scanner.nextLine());
            employeeList.add(new Employee(employeeCode, name, dateOfBirth, gender, IDNumber, phoneNumber, email, degree, position, salary));
//            Employee employee = new Employee(employeeCode, name, dateOfBirth, gender, IDNumber, phoneNumber, email, degree, position, salary);
            ReadAndWriteFile.writeFile(employeeList,pathFileEmloyee);
            System.err.println("Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        ReadAndWriteFile.readFile(employeeList,pathFileEmloyee);
//        for (Employee employee : employeeList) {
//            System.out.println(employee.toString());
//        }
    }

    @Override
    public void edit() {
        System.out.print("Nhập tên nhân viên muốn sửa: ");
        String nameSearch = scanner.nextLine();
        boolean flag = true;
        for (Employee employee : employeeList) {
            if (nameSearch.equals(employee.getName())) {
                flag = false;
                System.out.println("Nhập các thông tin cần sửa: ");
                System.out.print("Nhập tên nhân viên: ");
                String name = scanner.nextLine();
                System.out.print("Nhập ngày tháng năm sinh nhân viên: ");
                String dateOfBirth = scanner.nextLine();
                System.out.print("Nhập giới tính nhân viên: ");
                String gender = scanner.nextLine();
                System.out.print("Nhập số CMND nhân viên: ");
                int IDNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập SĐT nhân viên: ");
                int phoneNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập email nhân viên: ");
                String email = scanner.nextLine();
                System.out.print("Nhập bằng cấp nhân viên: ");
                String degree = scanner.nextLine();
                System.out.print("Nhập vị trí nhân viên: ");
                String position = scanner.nextLine();
                System.out.print("Nhập lương nhân viên: ");
                int salary = Integer.parseInt(scanner.nextLine());
                employee.setName(name);
                employee.setDateOfBirth(dateOfBirth);
                employee.setGender(gender);
                employee.setIDNumber(IDNumber);
                employee.setPhoneNumber(phoneNumber);
                employee.setEmail(email);
                employee.setDegree(degree);
                employee.setPosition(position);
                employee.setSalary(salary);
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
