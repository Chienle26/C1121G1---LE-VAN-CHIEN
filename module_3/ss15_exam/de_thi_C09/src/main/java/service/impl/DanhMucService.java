package service.impl;

import model.DanhMuc;
import reponsitory.IDanhMucRepository;
import reponsitory.impl.DanhMucRepository;
import service.IDanhMucService;

import java.util.List;

public class DanhMucService implements IDanhMucService {
    IDanhMucRepository iDanhMucRepository = new DanhMucRepository();
    @Override
    public List<DanhMuc> findAll() {
        return iDanhMucRepository.findAll();
    }
}
