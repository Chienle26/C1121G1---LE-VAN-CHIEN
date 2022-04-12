package com.chienle.service.impl;

import com.chienle.model.TheMuon;
import com.chienle.repository.ITheMuonRepository;
import com.chienle.service.ITheMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheMuonService implements ITheMuonService {

    @Autowired
    ITheMuonRepository iTheMuonRepository;

    @Override
    public List<TheMuon> findAll() {
        return iTheMuonRepository.findAll();
    }

    @Override
    public void save(TheMuon theMuon) {
        iTheMuonRepository.save(theMuon);
    }

    @Override
    public TheMuon findById(Integer id) {
        return iTheMuonRepository.findById(id).orElse(null);
    }
}
