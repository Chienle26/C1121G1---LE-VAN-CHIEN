package service;

import model.SanPhamDTO;

import java.util.List;

public interface ISanPhamService {
    List<SanPhamDTO> findAllDTO();
}
