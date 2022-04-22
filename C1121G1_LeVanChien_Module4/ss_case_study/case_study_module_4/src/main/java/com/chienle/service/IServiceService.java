package com.chienle.service;

import com.chienle.model.service_entity.RentType;
import com.chienle.model.service_entity.Service;
import com.chienle.model.service_entity.ServiceType;

import java.util.List;

public interface IServiceService {
    List<Service> findAllService();

    void save(Service service);

    List<RentType> findAllRentType();

    List<ServiceType> findAllServiceType();
}
