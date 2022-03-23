package reponsitory.impl;

import model.SanPhamDTO;
import reponsitory.ISanPhamRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository implements ISanPhamRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<SanPhamDTO> findAllDTO() {
        List<SanPhamDTO> sanPhamList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from san_pham " +
                    "inner join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc " +
                    "inner join mau_sac on san_pham.id_mau_sac = mau_sac.id_mau_sac;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idSanPham = resultSet.getInt("id_san_pham");
                String tenSanPham = resultSet.getString("ten");
                Double gia = resultSet.getDouble("gia");
                Integer soLuong = resultSet.getInt("so_luong");
                Integer idMauSac = resultSet.getInt("id_mau_sac");
                String moTa = resultSet.getString("mo_ta");
                Integer idDanhMuc = resultSet.getInt("id_danh_muc");
                String mauSac = resultSet.getString("mau_sac");
                String danhMuc = resultSet.getString("danh_muc");
                SanPhamDTO sanPham = new SanPhamDTO(idSanPham, tenSanPham, gia, soLuong, idMauSac, moTa, idDanhMuc, mauSac, danhMuc);
                sanPhamList.add(sanPham);
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
        return sanPhamList;
    }
}
