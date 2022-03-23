package reponsitory;

import model.SanPhamDTO;

import java.util.List;

public interface ISanPhamRepository {
    List<SanPhamDTO> findAllDTO();
}
