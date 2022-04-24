package com.chienle.repository.customer;

import com.chienle.model.customer.CustomerUseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerUseServiceRepository extends JpaRepository<CustomerUseService, Integer> {
    Page<CustomerUseService> findByCustomerNameContaining(String name, Pageable pageable);
}
