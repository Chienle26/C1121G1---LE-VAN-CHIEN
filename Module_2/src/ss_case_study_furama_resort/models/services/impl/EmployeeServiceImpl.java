package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Employee;
import ss_case_study_furama_resort.models.services.IEmployeeService;
import ss_case_study_furama_resort.utils.ReadAndWriteFileCSV;
import ss_case_study_furama_resort.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl<ReadAndWriteCSV> implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);
    String pathFileEmloyee = "src/ss_case_study_furama_resort/data/Employee.csv";
    ReadAndWriteFileCSV readAndWriteFileCSV = new ReadAndWriteFileCSV();
    List <Employee> employeeList = new ArrayList<>();

    @Override
    public void add()  {
        try {
            System.out.print("Nhập mã số nhân viên: ");
            String employeeCode = scanner.nextLine();
            System.out.print("Nhập tên nhân viên: ");
            String name = scanner.nextLine();
            System.out.print("Nhập ngày tháng năm sinh nhân viên: ");
            String dateOfBirth = RegexData.regexAge(scanner.nextLine(),RegexData.REGEX_BIRTHDAY);
            System.out.print("Nhập giới tính nhân viên: ");
            String gender = scanner.nextLine();
            System.out.print("Nhập số CMND nhân viên: ");
            String IDNumber = scanner.nextLine();
            System.out.print("Nhập SĐT nhân viên: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Nhập email nhân viên: ");
            String email = scanner.nextLine();
            System.out.print("Nhập bằng cấp nhân viên: ");
            String degree = scanner.nextLine();
            System.out.print("Nhập vị trí nhân viên: ");
            String position = scanner.nextLine();
            System.out.print("Nhập lương nhân viên: ");
            int salary = Integer.parseInt(scanner.nextLine());
            employeeList = new ArrayList<>();
            employeeList.add(new Employee(employeeCode, name, dateOfBirth, gender, IDNumber, phoneNumber, email, degree, position, salary));
            List<String> list = readAndWriteFileCSV.changeToStringList(employeeList);
            readAndWriteFileCSV.writeFileCSV(pathFileEmloyee,list,true);
            System.err.println("Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        List<String> list = readAndWriteFileCSV.readFileCSV(pathFileEmloyee);
        String[] array;

        for (int i = 0; i < list.size(); i++) {
            array = list.get(i).split(",");
            Employee employee = new Employee(array[0], array[1], array[2], array[3], array[4],array[5], array[6], array[7], array[8],Integer.parseInt(array[9]));
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        List<Employee> employeeList2 = new ArrayList<>();
        List<String> listTemp = readAndWriteFileCSV.readFileCSV(pathFileEmloyee);
            String[] array;
            for (int i = 0; i < listTemp.size(); i++) {
                array = listTemp.get(i).split(",");
                Employee employee = new Employee(array[0], array[1], array[2], array[3], array[4],array[5], array[6], array[7], array[8],Integer.parseInt(array[9]));
                employeeList2.add(employee);
            }
        System.out.print("Nhập tên nhân viên muốn sửa: ");
        String nameSearch = scanner.nextLine();
        boolean flag = true;
        for (Employee employee : employeeList2) {
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
                String IDNumber = scanner.nextLine();
                System.out.print("Nhập SĐT nhân viên: ");
                String phoneNumber = scanner.nextLine();
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
                System.out.println("list ne");
                for (Employee e:employeeList2){
                    System.out.println(e);
                }
                List<String> list = readAndWriteFileCSV.changeToStringList(employeeList2);
                readAndWriteFileCSV.writeFileCSV(pathFileEmloyee,list,false);
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
