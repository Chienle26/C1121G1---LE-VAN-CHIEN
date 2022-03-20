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
                Integer customerTypeCode = resultSet.getInt("ma_loai_khach");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String IDNumber = resultSet.getString("so_cmnd");
                Boolean gender = resultSet.getBoolean("gioi_tinh");
                String dateOfBirth = resultSet.getString("ngay_sinh");
                String name = resultSet.getString("ho_ten");
                String customerCode = resultSet.getString("ma_khach_hang");
                Customer customer = new Customer(customerCode, name, dateOfBirth, gender, IDNumber, phoneNumber, email, customerTypeCode, address);
                customerList.add(customer);
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
        return customerList;
    }

    @Override
    public void createCustomer(Customer customer) {
        Connection connection = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into khach_hang values (?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1,customer.getCustomerCode());
            preparedStatement.setInt(2,customer.getCustomerTypeCode());
            preparedStatement.setString(3,customer.getName());
            preparedStatement.setString(4,customer.getDateOfBirth());
            preparedStatement.setBoolean(5,customer.getGender());
            preparedStatement.setString(6,customer.getIDNumber());
            preparedStatement.setString(7,customer.getPhoneNumber());
            preparedStatement.setString(8,customer.getEmail());
            preparedStatement.setString(9,customer.getAddress());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
