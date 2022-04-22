package com.chienle.service.impl;

import com.chienle.model.service_entity.RentType;
import com.chienle.model.service_entity.Service;
import com.chienle.model.service_entity.ServiceType;
import com.chienle.repository.service.IRentTypeRepository;
import com.chienle.repository.service.IServiceRepository;
import com.chienle.repository.service.IServiceTypeRepository;
import com.chienle.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

    @Autowired
    IServiceRepository iServiceRepository;

    @Autowired
    IRentTypeRepository iRentTypeRepository;

    @Autowired
    IServiceTypeRepository iServiceTypeRepository;

    @Override
    public List<Service> findAllService() {
        return iServiceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public List<RentType> findAllRentType() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return iServiceTypeRepository.findAll();
    }
}
