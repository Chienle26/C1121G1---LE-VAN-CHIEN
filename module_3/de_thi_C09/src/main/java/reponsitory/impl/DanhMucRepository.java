package reponsitory.impl;

import model.DanhMuc;
import reponsitory.IDanhMucRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhMucRepository implements IDanhMucRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<DanhMuc> findAll() {
        List<DanhMuc> danhMucList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select id_danh_muc, danh_muc from danh_muc;");
            ResultSet resultSet = preparedStatement.executeQuery();
            DanhMuc danhMuc = null;
            while (resultSet.next()){
                Integer idDanhMuc = resultSet.getInt("id_danh_muc");
                String danhMuc2 = resultSet.getString("danh_muc");
                danhMuc = new DanhMuc(idDanhMuc,danhMuc2);
                danhMucList.add(danhMuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhMucList;
    }
}
