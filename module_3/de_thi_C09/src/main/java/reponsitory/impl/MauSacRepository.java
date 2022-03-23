package reponsitory.impl;

import model.DanhMuc;
import model.MauSac;
import reponsitory.IMauSacRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MauSacRepository implements IMauSacRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<MauSac> findAll() {
        List<MauSac> mauSacList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select id_mau_sac, mau_sac from mau_sac;");
            ResultSet resultSet = preparedStatement.executeQuery();
            MauSac mauSac = null;
            while (resultSet.next()){
                Integer idMauSac = resultSet.getInt("id_mau_sac");
                String mauSac2 = resultSet.getString("mau_sac");
                mauSac = new MauSac(idMauSac,mauSac2);
                mauSacList.add(mauSac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mauSacList;
    }
}
