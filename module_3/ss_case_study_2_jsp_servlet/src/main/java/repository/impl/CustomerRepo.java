package repository.impl;

import model.Customer;
import model.CustomerDTO;
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
                Customer customer = new Customer(name, dateOfBirth, IDNumber, phoneNumber, email, address, customerCode, customerTypeCode, gender);
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
    public List<CustomerDTO> findAllDTO() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        Connection connection = this.baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from khach_hang " +
                    "inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach;");
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
                String customerName = resultSet.getString("ten_loai_khach");
                CustomerDTO customer = new CustomerDTO(name, dateOfBirth, IDNumber, phoneNumber, email, address, customerCode, customerTypeCode, gender, customerName);
                customerDTOList.add(customer);
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
        return customerDTOList;
    }

    @Override
    public void createCustomer(Customer customer) {
        Connection connection = null;
        connection = this.baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into khach_hang (ma_khach_hang,ma_loai_khach,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi) values (?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, customer.getCustomerCode());
            preparedStatement.setInt(2, customer.getCustomerTypeCode());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getDateOfBirth());
            preparedStatement.setBoolean(5, customer.getGender());
            preparedStatement.setString(6, customer.getIDNumber());
            preparedStatement.setString(7, customer.getPhoneNumber());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());
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

    @Override
    public Customer findCustomerById(String id) {
        Connection connection = null;
        Customer customer = null;
        try {
            connection = baseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from khach_hang where ma_khach_hang = ?");
            preparedStatement.setString(1, id);
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
                customer = new Customer(name, dateOfBirth, IDNumber, phoneNumber, email, address, customerCode, customerTypeCode, gender);
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
        return customer;
    }

    @Override
    public void editCustomer(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = baseRepo.getConnection();
            preparedStatement = connection.prepareStatement("update khach_hang set ma_khach_hang= ?,ma_loai_khach= ?,ho_ten= ?,ngay_sinh= ?,gioi_tinh= ?,so_cmnd= ?,so_dien_thoai= ?,email= ?,dia_chi= ? where ma_khach_hang = ? ;");
            preparedStatement.setString(1, customer.getCustomerCode());
            preparedStatement.setInt(2, customer.getCustomerTypeCode());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getDateOfBirth());
            preparedStatement.setBoolean(5, customer.getGender());
            preparedStatement.setString(6, customer.getIDNumber());
            preparedStatement.setString(7, customer.getPhoneNumber());
            preparedStatement.setString(8, customer.getEmail());
            preparedStatement.setString(9, customer.getAddress());
            preparedStatement.setString(10, customer.getCustomerCode());
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

    @Override
    public void deleteCustomer(Integer id) {
        Connection connection = null;
        try {
            connection = baseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from khach_hang where ma_khach_hang = ? ;");
            preparedStatement.setInt(1, id);
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

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        Customer customer = null;
        try {
            connection = baseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from khach_hang where ho_ten like concat(\"%\",?,\"%\");");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerCode(resultSet.getString("ma_khach_hang"));
                customer.setGender(resultSet.getBoolean("gioi_tinh"));
                customer.setCustomerTypeCode(resultSet.getInt("ma_loai_khach"));
                customer.setName(resultSet.getString("ho_ten"));
                customer.setAddress(resultSet.getString("dia_chi"));
                customer.setDateOfBirth(resultSet.getString("ngay_sinh"));
                customer.setIDNumber(resultSet.getString("so_cmnd"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPhoneNumber(resultSet.getString("so_dien_thoai"));
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
    public boolean checkCustomerCodeExist(String customerCode) {
        List<Customer> customerList = findAll();
        for (Customer customer : customerList) {
            if (customer.getCustomerCode().equals(customerCode)) {
                return true;
            }
        }
        return false;
    }
}
