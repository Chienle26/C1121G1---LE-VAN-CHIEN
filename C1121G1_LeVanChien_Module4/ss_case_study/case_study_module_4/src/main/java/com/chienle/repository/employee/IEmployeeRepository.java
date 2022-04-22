package com.chienle.repository.employee;

import com.chienle.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findByEmployeeNameContainingOrderByEmployeeId(String name, Pageable pageable);
}
