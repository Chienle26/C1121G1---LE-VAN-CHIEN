package service;

import model.Customer;
import model.Employee;

import java.util.List;

public interface IEmployeeService extends IService {
    List<Employee> findAll();
}
