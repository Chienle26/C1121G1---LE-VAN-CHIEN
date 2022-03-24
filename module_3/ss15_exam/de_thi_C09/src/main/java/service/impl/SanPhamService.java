package service.impl;

import model.SanPham;
import model.SanPhamDTO;
import reponsitory.ISanPhamRepository;
import reponsitory.impl.SanPhamRepository;
import service.ISanPhamService;

import java.util.List;

public class SanPhamService implements ISanPhamService {
    ISanPhamRepository iSanPhamRepository = new SanPhamRepository();
    @Override
    public List<SanPhamDTO> findAllDTO() {
        return iSanPhamRepository.findAllDTO();
    }

    @Override
    public List<SanPham> findAll() {
        return iSanPhamRepository.findAll();
    }

    @Override
    public void createSanPham(SanPham sanPham) {
        iSanPhamRepository.createSanPham(sanPham);
    }

    @Override
    public void deleteSanPham(Integer id) {
        iSanPhamRepository.deleteSanPham(id);
    }

    @Override
    public List<SanPhamDTO> searchTheoTen(String tenSanPham) {
        return iSanPhamRepository.searchTheoTen(tenSanPham);
    }

    @Override
    public List<SanPhamDTO> searchTheoGia(Double gia) {
        return iSanPhamRepository.searchTheoGia(gia);
    }

    @Override
    public List<SanPhamDTO> searchTheoDanhMuc(String danhMuc) {
        return iSanPhamRepository.searchTheoDanhMuc(danhMuc);
    }

    @Override
    public List<SanPhamDTO> searchTheoMau(String mauSac) {
        return iSanPhamRepository.searchTheoMau(mauSac);
    }

    @Override
    public SanPham findSanPhamById(Integer idSanPham) {
        return iSanPhamRepository.findSanPhamById(idSanPham);
    }

    @Override
    public void editSanPham(SanPham sanPham) {
        iSanPhamRepository.editSanPham(sanPham);
    }
}
