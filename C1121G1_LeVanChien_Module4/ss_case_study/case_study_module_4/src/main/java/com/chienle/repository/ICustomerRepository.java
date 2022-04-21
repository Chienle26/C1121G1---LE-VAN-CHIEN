package com.chienle.repository;

import com.chienle.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByCustomerNameContainingOrderByCustomerId(String name, Pageable pageable);
}
