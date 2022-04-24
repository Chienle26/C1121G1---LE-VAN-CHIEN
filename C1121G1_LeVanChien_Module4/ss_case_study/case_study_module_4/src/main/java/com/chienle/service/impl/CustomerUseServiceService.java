package com.chienle.service.impl;

import com.chienle.model.customer.CustomerUseService;
import com.chienle.repository.customer.ICustomerUseServiceRepository;
import com.chienle.service.ICustomerUseServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerUseServiceService implements ICustomerUseServiceService {
    @Autowired
    ICustomerUseServiceRepository iCustomerUseServiceRepository;

    @Override
    public Page<CustomerUseService> findAllCustomerUseService(String name, Pageable pageable) {
        Page<CustomerUseService> customerUseServicePage = iCustomerUseServiceRepository.findByCustomerNameContaining(name, pageable);

        for (CustomerUseService customerUseService : customerUseServicePage) {
            customerUseService.setTotalMoney(customerUseService.calculateTotalMoney());
        }

        return customerUseServicePage;
    }
}
