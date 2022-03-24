package reponsitory;

import model.SanPham;
import model.SanPhamDTO;

import java.util.List;

public interface ISanPhamRepository {
    List<SanPhamDTO> findAllDTO();

    List<SanPham> findAll();

    void createSanPham(SanPham sanPham);

    void deleteSanPham(Integer id);

    List<SanPhamDTO> searchTheoTen(String tenSanPham);

    List<SanPhamDTO> searchTheoGia(Double gia);

    List<SanPhamDTO> searchTheoDanhMuc(String danhMuc);

    List<SanPhamDTO> searchTheoMau(String mauSac);

    SanPham findSanPhamById(Integer idSanPham);

    void editSanPham(SanPham sanPham);
}
