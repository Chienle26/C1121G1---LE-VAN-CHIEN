package repository.impl;

import model.CustomerType;
import repository.ICustomerTypeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepo implements ICustomerTypeRepo {
    BaseRepo baseRepo = new BaseRepo();
    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = baseRepo.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from loai_khach;");
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType = null;
            while (resultSet.next()){
                Integer customerTypeCode = resultSet.getInt("ma_loai_khach");
                String customerTypeName = resultSet.getString("ten_loai_khach");
                customerType = new CustomerType(customerTypeCode,customerTypeName);
                customerTypeList.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerTypeList;
    }
}
