package service.impl;

import model.Customer;
import model.Employee;
import repository.IEmployeeRepo;
import repository.IRepository;
import repository.impl.EmployeeRepo;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepo iEmployeeRepo = new EmployeeRepo();
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepo.findAll();
    }
}
