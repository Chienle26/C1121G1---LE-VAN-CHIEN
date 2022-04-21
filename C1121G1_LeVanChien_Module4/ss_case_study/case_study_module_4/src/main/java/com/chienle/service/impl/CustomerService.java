package com.chienle.service.impl;

import com.chienle.model.customer.Customer;
import com.chienle.repository.ICustomerRepository;
import com.chienle.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllPaging(String name, Pageable pageable) {
        return iCustomerRepository.findByCustomerNameContainingOrderByCustomerId(name, pageable);
    }


}
