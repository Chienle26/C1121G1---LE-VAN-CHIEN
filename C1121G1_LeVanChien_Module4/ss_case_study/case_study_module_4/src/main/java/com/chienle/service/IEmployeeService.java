package com.chienle.service;

import com.chienle.model.employee.Division;
import com.chienle.model.employee.EducationDegree;
import com.chienle.model.employee.Employee;
import com.chienle.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAllPaging(String name, Pageable pageable);

    List<Employee> findAll();

    List<Position> findAllPosition();

    List<EducationDegree> findAllEducationDegree();

    List<Division> findAllDivision();

    void save(Employee employee);

    Employee findById(Integer id);
}
