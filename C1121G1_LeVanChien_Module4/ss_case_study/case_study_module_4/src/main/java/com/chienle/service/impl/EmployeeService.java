package com.chienle.service.impl;

import com.chienle.model.employee.Division;
import com.chienle.model.employee.EducationDegree;
import com.chienle.model.employee.Employee;
import com.chienle.model.employee.Position;
import com.chienle.repository.employee.IDivisionRepository;
import com.chienle.repository.employee.IEducationDegreeRepository;
import com.chienle.repository.employee.IEmployeeRepository;
import com.chienle.repository.employee.IPositionRepository;
import com.chienle.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    IDivisionRepository iDivisionRepository;

    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;

    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public Page<Employee> findAllPaging(String name, Pageable pageable) {
        return iEmployeeRepository.findByEmployeeNameContainingOrderByEmployeeId(name, pageable);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return iPositionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return iEducationDegreeRepository.findAll();
    }

    @Override
    public List<Division> findAllDivision() {
        return iDivisionRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }
}
