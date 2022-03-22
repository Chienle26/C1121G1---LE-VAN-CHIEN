package repository.impl;

import model.Contract;
import model.Customer;
import repository.IContractRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepo implements IContractRepo {
    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = this.baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hop_dong;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer contractId = Integer.valueOf(resultSet.getString("ma_hop_dong"));
                String startDate = resultSet.getString("ngay_lam_hop_dong");
                String endDate = resultSet.getString("ngay_ket_thuc");
                Double deposit = Double.valueOf(resultSet.getString("tien_dat_coc"));
//                Double totalMoney = Double.valueOf(resultSet.getString("dia_chi"));
                Contract contract = new Contract(contractId,startDate,endDate,deposit);
                contractList.add(contract);
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
        return contractList;
    }
}
