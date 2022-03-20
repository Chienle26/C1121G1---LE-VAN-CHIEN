package repository;

import model.Customer;
import model.Employee;

import java.util.List;

public interface ICustomerRepo extends IRepository{
    List<Customer> findAll();

    void createCustomer(Customer customer);
}
