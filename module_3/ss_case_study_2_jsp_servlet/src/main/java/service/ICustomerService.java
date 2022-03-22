package service;

import model.Customer;
import model.CustomerDTO;
import model.Employee;

import java.util.List;

public interface ICustomerService extends IService{

    List<Customer> findAll();

    List<CustomerDTO> findAllDTO();

    void createCustomer(Customer customer);

    Customer findCustomerById(Integer id);

    void editCustomer(Customer customer);

    void deleteCustomer(Integer id);

    List<Customer> searchByName(String name);
}
