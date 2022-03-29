package service;

import DTO.TheMuonSachDTO;
import model.HocSinh;
import model.Sach;
import model.TheMuonSach;

import java.util.List;

public interface ITheMuonSachService {
    List<Sach> findAllSach();

    List<HocSinh> findAllHocSinh();

    List<TheMuonSachDTO> findAllDTO();

    void createTheMuonSach(TheMuonSach theMuonSach);
}
