package service.impl;

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
}
