package service.impl;

import model.MauSac;
import reponsitory.impl.MauSacRepository;
import service.IMauSacService;

import java.util.List;

public class MauSacService implements IMauSacService {
    MauSacRepository mauSacRepository = new MauSacRepository();
    @Override
    public List<MauSac> findAll() {
        return mauSacRepository.findAll();
    }
}
