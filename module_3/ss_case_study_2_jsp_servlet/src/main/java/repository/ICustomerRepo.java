package repository;

import model.Customer;
import model.CustomerDTO;
import model.Employee;

import java.util.List;

public interface ICustomerRepo extends IRepository{
    List<Customer> findAll();

    List<CustomerDTO> findAllDTO();

    void createCustomer(Customer customer);

    Customer findCustomerById(String id);

    void editCustomer(Customer customer);

    void deleteCustomer(Integer id);

    List<Customer> searchByName(String name);

    boolean checkCustomerCodeExist(String customerCode);
}
