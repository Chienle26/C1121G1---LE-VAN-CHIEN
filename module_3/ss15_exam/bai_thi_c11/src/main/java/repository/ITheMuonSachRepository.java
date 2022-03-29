package repository;

import DTO.TheMuonSachDTO;
import model.HocSinh;
import model.Sach;
import model.TheMuonSach;

import java.util.List;

public interface ITheMuonSachRepository {
    List<TheMuonSachDTO> findAllDTO();

    List<Sach> findAllSach();

    List<HocSinh> findAllHocSinh();

    void createTheMuonSach(TheMuonSach theMuonSach);
}
