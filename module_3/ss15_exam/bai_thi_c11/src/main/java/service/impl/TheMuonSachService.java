package service.impl;

import DTO.TheMuonSachDTO;
import model.HocSinh;
import model.Sach;
import model.TheMuonSach;
import repository.ITheMuonSachRepository;
import repository.impl.TheMuonSachRepository;
import service.ITheMuonSachService;

import java.util.List;

public class TheMuonSachService implements ITheMuonSachService {
    ITheMuonSachRepository iTheMuonSachRepository = new TheMuonSachRepository();

    @Override
    public List<Sach> findAllSach() {
        return iTheMuonSachRepository.findAllSach();
    }

    @Override
    public List<HocSinh> findAllHocSinh() {
        return iTheMuonSachRepository.findAllHocSinh();
    }

    @Override
    public List<TheMuonSachDTO> findAllDTO() {
        return iTheMuonSachRepository.findAllDTO();
    }

    @Override
    public void createTheMuonSach(TheMuonSach theMuonSach) {
        iTheMuonSachRepository.createTheMuonSach(theMuonSach);
    }
}
