package repository.impl;

import model.Customer;
import repository.ICustomerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = this.baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from khach_hang;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String address = resultSet.getString("dia_chi");
                Integer customerType = resultSet.getInt("ma_loai_khach");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String IDNumber = resultSet.getString("so_cmnd");
                Boolean gender = resultSet.getBoolean("gioi_tinh");
                String dateOfBirth = resultSet.getString("ngay_sinh");
                String name = resultSet.getString("ho_ten");
                Integer customerCode = resultSet.getInt("ma_khach_hang");
                Customer customer = new Customer(customerCode, name, dateOfBirth, gender, IDNumber, phoneNumber, email, customerType, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
