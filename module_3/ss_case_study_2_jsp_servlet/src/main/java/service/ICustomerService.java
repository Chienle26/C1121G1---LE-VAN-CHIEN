package service;

import model.Customer;
import model.Employee;

import java.util.List;

public interface ICustomerService extends IService{

    List<Customer> findAll();

    void createCustomer(Customer customer);
}
