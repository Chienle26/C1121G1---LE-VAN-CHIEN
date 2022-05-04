package com.chienle.service.impl;

import com.chienle.model.customer.Customer;
import com.chienle.model.customer.CustomerType;
import com.chienle.repository.customer.ICustomerRepository;
import com.chienle.repository.customer.ICustomerTypeRepository;
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

    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllPaging(String name, Pageable pageable) {
        return iCustomerRepository.findByCustomerNameContainingOrderByCustomerId(name, pageable);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepository.delete(customer);
    }

    @Override
    public Customer findByCustomerCode(String customerCode) {
        return iCustomerRepository.findByCustomerCode(customerCode);
    }


}
