package reponsitory.impl;

import model.SanPham;
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

    @Override
    public List<SanPham> findAll() {
        List<SanPham> sanPhamList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from san_pham;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idSanPham = resultSet.getInt("id_san_pham");
                String tenSanPham = resultSet.getString("ten");
                Double gia = resultSet.getDouble("gia");
                Integer soLuong = resultSet.getInt("so_luong");
                Integer idMauSac = resultSet.getInt("id_mau_sac");
                String moTa = resultSet.getString("mo_ta");
                Integer idDanhMuc = resultSet.getInt("id_danh_muc");
                SanPham sanPham = new SanPham(idSanPham, tenSanPham, gia, soLuong, idMauSac, moTa, idDanhMuc);
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

    @Override
    public void createSanPham(SanPham sanPham) {
        Connection connection = null;
        connection = this.baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into san_pham (id_san_pham, ten, gia, so_luong, id_mau_sac, mo_ta, id_danh_muc) values (?,?,?,?,?,?,?);");
            preparedStatement.setInt(1, sanPham.getIdSanPham());
            preparedStatement.setString(2, sanPham.getTenSanPham());
            preparedStatement.setDouble(3, sanPham.getGia());
            preparedStatement.setInt(4, sanPham.getSoLuong());
            preparedStatement.setInt(5, sanPham.getIdMauSac());
            preparedStatement.setString(6, sanPham.getMoTa());
            preparedStatement.setInt(7, sanPham.getIdDanhMuc());
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
    public void deleteSanPham(Integer id) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from san_pham where id_san_pham = ? ;");
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
    public List<SanPhamDTO> searchTheoTen(String tenSanPham) {
        List<SanPhamDTO> sanPhamList = new ArrayList<>();
        Connection connection = null;
        SanPhamDTO sanPham = null;
        try {
            connection = baseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select id_san_pham, ten, gia, so_luong, mo_ta, danh_muc, mau_sac from san_pham\n" +
                        "                    inner join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc \n" +
                        "                    inner join mau_sac on san_pham.id_mau_sac = mau_sac.id_mau_sac\n" +
                        "                    where ten like concat(\"%\",?,\"%\");");
//            PreparedStatement preparedStatement = connection.prepareStatement("select id_san_pham, ten, gia, so_luong, mo_ta, danh_muc, mau_sac  from san_pham " +
//                    "inner join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc " +
//                    "inner join mau_sac on san_pham.id_mau_sac = mau_sac.id_mau_sac " +
//                    "where ten = ?");
            preparedStatement.setString(1, tenSanPham);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sanPham = new SanPhamDTO();
                sanPham.setIdSanPham(resultSet.getInt("id_san_pham"));
                sanPham.setTenSanPham(resultSet.getString("ten"));
                sanPham.setGia(resultSet.getDouble("gia"));
                sanPham.setSoLuong(resultSet.getInt("so_luong"));
//                sanPham.setIdMauSac(resultSet.getInt("id_mau_sac"));
                sanPham.setMoTa(resultSet.getString("mo_ta"));
//                sanPham.setIdDanhMuc(resultSet.getInt("id_danh_muc"));
                sanPham.setDanhMuc(resultSet.getString("danh_muc"));
                sanPham.setMauSac(resultSet.getString("mau_sac"));
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

    @Override
    public List<SanPhamDTO> searchTheoGia(Double gia) {
        List<SanPhamDTO> sanPhamList = new ArrayList<>();
        Connection connection = null;
        SanPhamDTO sanPham = null;
        try {
            connection = baseRepository.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("select id_san_pham, ten, gia, so_luong, mo_ta, danh_muc, mau_sac from san_pham\n" +
//                    "                    inner join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc \n" +
//                    "                    inner join mau_sac on san_pham.id_mau_sac = mau_sac.id_mau_sac\n" +
//                    "                    where ten like concat(\"%\",?,\"%\");");
            PreparedStatement preparedStatement = connection.prepareStatement("select id_san_pham, ten, gia, so_luong, mo_ta, danh_muc, mau_sac  from san_pham " +
                    "inner join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc " +
                    "inner join mau_sac on san_pham.id_mau_sac = mau_sac.id_mau_sac " +
                    "where gia = ?");
            preparedStatement.setDouble(1, gia);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sanPham = new SanPhamDTO();
                sanPham.setIdSanPham(resultSet.getInt("id_san_pham"));
                sanPham.setTenSanPham(resultSet.getString("ten"));
                sanPham.setGia(resultSet.getDouble("gia"));
                sanPham.setSoLuong(resultSet.getInt("so_luong"));
//                sanPham.setIdMauSac(resultSet.getInt("id_mau_sac"));
                sanPham.setMoTa(resultSet.getString("mo_ta"));
//                sanPham.setIdDanhMuc(resultSet.getInt("id_danh_muc"));
                sanPham.setDanhMuc(resultSet.getString("danh_muc"));
                sanPham.setMauSac(resultSet.getString("mau_sac"));
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

    @Override
    public List<SanPhamDTO> searchTheoDanhMuc(String danhMuc) {
        List<SanPhamDTO> sanPhamList = new ArrayList<>();
        Connection connection = null;
        SanPhamDTO sanPham = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select id_san_pham, ten, gia, so_luong, mo_ta, danh_muc, mau_sac from san_pham\n" +
                    "                    inner join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc \n" +
                    "                    inner join mau_sac on san_pham.id_mau_sac = mau_sac.id_mau_sac\n" +
                    "                    where danh_muc like concat(\"%\",?,\"%\");");
//            PreparedStatement preparedStatement = connection.prepareStatement("select id_san_pham, ten, gia, so_luong, mo_ta, danh_muc, mau_sac  from san_pham " +
//                    "inner join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc " +
//                    "inner join mau_sac on san_pham.id_mau_sac = mau_sac.id_mau_sac " +
//                    "where ten = ?");
            preparedStatement.setString(1, danhMuc);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sanPham = new SanPhamDTO();
                sanPham.setIdSanPham(resultSet.getInt("id_san_pham"));
                sanPham.setTenSanPham(resultSet.getString("ten"));
                sanPham.setGia(resultSet.getDouble("gia"));
                sanPham.setSoLuong(resultSet.getInt("so_luong"));
//                sanPham.setIdMauSac(resultSet.getInt("id_mau_sac"));
                sanPham.setMoTa(resultSet.getString("mo_ta"));
//                sanPham.setIdDanhMuc(resultSet.getInt("id_danh_muc"));
                sanPham.setDanhMuc(resultSet.getString("danh_muc"));
                sanPham.setMauSac(resultSet.getString("mau_sac"));
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

    @Override
    public List<SanPhamDTO> searchTheoMau(String mauSac) {
        List<SanPhamDTO> sanPhamList = new ArrayList<>();
        Connection connection = null;
        SanPhamDTO sanPham = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select id_san_pham, ten, gia, so_luong, mo_ta, danh_muc, mau_sac from san_pham\n" +
                    "                    inner join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc \n" +
                    "                    inner join mau_sac on san_pham.id_mau_sac = mau_sac.id_mau_sac\n" +
                    "                    where mau_sac like concat(\"%\",?,\"%\");");
//            PreparedStatement preparedStatement = connection.prepareStatement("select id_san_pham, ten, gia, so_luong, mo_ta, danh_muc, mau_sac  from san_pham " +
//                    "inner join danh_muc on san_pham.id_danh_muc = danh_muc.id_danh_muc " +
//                    "inner join mau_sac on san_pham.id_mau_sac = mau_sac.id_mau_sac " +
//                    "where ten = ?");
            preparedStatement.setString(1, mauSac);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sanPham = new SanPhamDTO();
                sanPham.setIdSanPham(resultSet.getInt("id_san_pham"));
                sanPham.setTenSanPham(resultSet.getString("ten"));
                sanPham.setGia(resultSet.getDouble("gia"));
                sanPham.setSoLuong(resultSet.getInt("so_luong"));
//                sanPham.setIdMauSac(resultSet.getInt("id_mau_sac"));
                sanPham.setMoTa(resultSet.getString("mo_ta"));
//                sanPham.setIdDanhMuc(resultSet.getInt("id_danh_muc"));
                sanPham.setDanhMuc(resultSet.getString("danh_muc"));
                sanPham.setMauSac(resultSet.getString("mau_sac"));
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

    @Override
    public SanPham findSanPhamById(Integer idSanPham) {
        Connection connection = null;
        SanPham sanPham = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select id_san_pham, ten, gia, so_luong, id_mau_sac, mo_ta, id_danh_muc from san_pham where id_san_pham = ?");
            preparedStatement.setInt(1, idSanPham);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer idSanPham2 = resultSet.getInt("id_san_pham");
                String tenSanPham = resultSet.getString("ten");
                Double gia = resultSet.getDouble("gia");
                Integer soLuong = resultSet.getInt("so_luong");
                Integer idMauSac = resultSet.getInt("id_mau_sac");
                String moTa = resultSet.getString("mo_ta");
                Integer idDanhMuc = resultSet.getInt("id_danh_muc");
                sanPham = new SanPham(idSanPham2, tenSanPham, gia, soLuong, idMauSac, moTa, idDanhMuc);
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
        return sanPham;
    }

    @Override
    public void editSanPham(SanPham sanPham) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = baseRepository.getConnection();
            preparedStatement = connection.prepareStatement("update san_pham set id_san_pham= ?,ten= ?, gia= ?,so_luong= ?,id_mau_sac= ?,mo_ta= ?,id_danh_muc= ? where id_san_pham= ? ;");
            preparedStatement.setInt(1, sanPham.getIdSanPham());
            preparedStatement.setString(2, sanPham.getTenSanPham());
            preparedStatement.setDouble(3, sanPham.getGia());
            preparedStatement.setInt(4, sanPham.getSoLuong());
            preparedStatement.setInt(5, sanPham.getIdMauSac());
            preparedStatement.setString(6, sanPham.getMoTa());
            preparedStatement.setInt(7, sanPham.getIdDanhMuc());
            preparedStatement.setInt(8, sanPham.getIdSanPham());
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
