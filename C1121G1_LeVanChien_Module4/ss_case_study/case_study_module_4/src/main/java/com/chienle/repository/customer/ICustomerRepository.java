package com.chienle.repository.customer;

import com.chienle.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c where c.active=1 and c.customerName like concat('%', :customerName ,'%') ")
//    @Query(value = "select * from customer where customer.active = 1 and customer.customer_name like concat('%',:customer_name,'%')", nativeQuery = true)
    Page<Customer> findByCustomerNameContainingOrderByCustomerId(@Param("customerName")String name, Pageable pageable);
}
