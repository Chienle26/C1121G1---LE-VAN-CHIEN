package com.chienle.repository.employee;

import com.chienle.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select c from Employee c where c.active=1 and c.employeeName like concat('%', :employeeName ,'%') ")
    Page<Employee> findByEmployeeNameContainingOrderByEmployeeId(@Param("employeeName") String name, Pageable pageable);
}
