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
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = this.baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from nhan_vien;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String address = resultSet.getString("dia_chi");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String IDNumber = resultSet.getString("so_cmnd");
                String dateOfBirth = resultSet.getString("ngay_sinh");
                String name = resultSet.getString("ho_ten");
                String employeeCode = resultSet.getString("ma_nhan_vien");
                Double salary = Double.valueOf(resultSet.getString("luong"));
                Integer divisionCode = Integer.valueOf(resultSet.getString("ma_bo_phan"));
                Integer degreeCode= Integer.valueOf(resultSet.getString("ma_trinh_do"));
                Integer positionCode= Integer.valueOf(resultSet.getString("ma_vi_tri"));
                Employee employee = new Employee(name, dateOfBirth, IDNumber, phoneNumber, email, address, employeeCode,degreeCode,positionCode,divisionCode,salary);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }
}
