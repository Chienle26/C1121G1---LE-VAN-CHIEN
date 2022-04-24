package com.chienle.service;

import com.chienle.model.customer.CustomerUseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerUseServiceService {
    Page<CustomerUseService> findAllCustomerUseService(String name, Pageable pageable);
}
