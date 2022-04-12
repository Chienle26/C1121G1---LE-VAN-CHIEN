package com.chienle.service;

import com.chienle.model.TheMuon;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ITheMuonService {
    List<TheMuon> findAll();

    void save(TheMuon theMuon);

    TheMuon findById(Integer id);
}
