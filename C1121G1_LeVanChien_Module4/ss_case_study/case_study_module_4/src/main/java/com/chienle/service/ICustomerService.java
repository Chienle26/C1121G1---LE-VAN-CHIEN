package com.chienle.service;

import com.chienle.model.customer.Customer;
import com.chienle.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Page<Customer> findAllPaging(String name, Pageable pageable);

    List<CustomerType> findAllCustomerType();

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Customer customer);

    Customer findByCustomerCode(String customerCode);
}
