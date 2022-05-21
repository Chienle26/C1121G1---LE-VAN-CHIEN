package com.chienle.service;

import com.chienle.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void deleteById(Integer id);
}
