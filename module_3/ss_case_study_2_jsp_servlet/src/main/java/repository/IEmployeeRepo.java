package repository;

import model.Customer;
import model.Employee;

import java.util.List;

public interface IEmployeeRepo extends IRepository {
    List<Employee> findAll();
}
