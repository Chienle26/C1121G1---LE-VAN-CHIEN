package repository.impl;

import DTO.TheMuonSachDTO;
import model.HocSinh;
import model.Sach;
import model.TheMuonSach;
import repository.ITheMuonSachRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheMuonSachRepository implements ITheMuonSachRepository {
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<TheMuonSachDTO> findAllDTO() {
        return null;
    }

    @Override
    public List<Sach> findAllSach() {
        List<Sach> sachList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select ma_sach, ten_sach, tac_gia, mo_ta, so_luong from sach;");
            ResultSet resultSet = preparedStatement.executeQuery();
            Sach sach = null;
            while (resultSet.next()) {
                String maSach = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                Integer soLuong = resultSet.getInt("so_luong");
                sach = new Sach(maSach, tenSach,tacGia,moTa,soLuong);
                sachList.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sachList;
    }

    @Override
    public List<HocSinh> findAllHocSinh() {
        List<HocSinh> hocSinhList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select ma_hoc_sinh, ma_hoc_sinh, lop from hoc_sinh;");
            ResultSet resultSet = preparedStatement.executeQuery();
            HocSinh hocSinh = null;
            while (resultSet.next()) {
                String maHocSinh = resultSet.getString("ma_hoc_sinh");
                String tenHocSinh = resultSet.getString("ma_hoc_sinh");
                String lop = resultSet.getString("lop");
                hocSinh = new HocSinh(maHocSinh, tenHocSinh,lop);
                hocSinhList.add(hocSinh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hocSinhList;
    }

    @Override
    public void createTheMuonSach(TheMuonSach theMuonSach) {
        Connection connection = null;
        connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into the_muon_sach  ( ma_muon_sach, ma_sach, ma_hoc_sinh, trang_thai, ngay_muon, ngay_tra) values (?,?,?,?,?,?);");
            preparedStatement.setString(1, theMuonSach.getMaMuonSach());
            preparedStatement.setString(2, theMuonSach.getMaSach());
            preparedStatement.setString(3, theMuonSach.getMaHocSinh());
            preparedStatement.setBoolean(4, theMuonSach.getTrangThai());
            preparedStatement.setString(5, theMuonSach.getNgayMuon());
            preparedStatement.setString(6, theMuonSach.getNgayTra());
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