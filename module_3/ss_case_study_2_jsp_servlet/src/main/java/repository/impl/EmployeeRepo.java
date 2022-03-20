package repository.impl;

import model.Customer;
import model.Employee;
import repository.IEmployeeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo {
    BaseRepo baseRepo = new BaseRepo();
    @Override
    public List<Employee> findAll() {
//        List<Employee> employeeList = new ArrayList<>();
//        Connection connection = this.baseRepo.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from nhan_vien;");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                String address = resultSet.getString("dia_chi");
//                Integer customerTypeCode = resultSet.getInt("ma_loai_khach");
//                String email = resultSet.getString("email");
//                String phoneNumber = resultSet.getString("so_dien_thoai");
//                String IDNumber = resultSet.getString("so_cmnd");
//                Boolean gender = resultSet.getBoolean("gioi_tinh");
//                String dateOfBirth = resultSet.getString("ngay_sinh");
//                String name = resultSet.getString("ho_ten");
//                String customerCode = resultSet.getString("ma_khach_hang");
//                Employee employee = new Employee(customerCode, name, dateOfBirth, gender, IDNumber, phoneNumber, email, customerTypeCode, address);
//                employeeList.add(employee);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return employeeList;
        return null;
    }
}
