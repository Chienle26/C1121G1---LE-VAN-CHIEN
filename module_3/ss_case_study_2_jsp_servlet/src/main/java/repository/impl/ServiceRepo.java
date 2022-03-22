package repository.impl;

import model.Customer;
import model.Facility;
import model.Service;
import repository.IServiceRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepo implements IServiceRepo {
    BaseRepo baseRepo = new BaseRepo();
    @Override
    public List<Facility> findAll() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = this.baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from dich_vu;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nameService= resultSet.getString("ten_dich_vu");
                String standardRoom= resultSet.getString("tieu_chuan_phong");
                String description= resultSet.getString("mo_ta_tien_nghi_khac");
                Double area= Double.valueOf(resultSet.getString("dien_tich"));
                Double rentalCosts= Double.valueOf(resultSet.getString("chi_phi_thue"));
                Integer maxPeople= Integer.valueOf(resultSet.getString("so_nguoi_toi_da"));
                Integer rentalType= Integer.valueOf(resultSet.getString("ma_kieu_thue"));
                Integer serviceCode= Integer.valueOf(resultSet.getString("ma_dich_vu"));
                Facility facility = new Service(nameService,area,rentalCosts,maxPeople,rentalType,serviceCode,standardRoom,description);
                facilityList.add(facility);
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
        return facilityList;
    }
}
