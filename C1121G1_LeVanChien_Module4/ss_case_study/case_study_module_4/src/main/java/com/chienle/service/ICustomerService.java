package com.chienle.service;

import com.chienle.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Page<Customer> findAllPaging(String name, Pageable pageable);
}
