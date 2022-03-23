package service;

import model.Customer;
import model.CustomerDTO;
import model.Employee;

import java.util.List;
import java.util.Map;

public interface ICustomerService extends IService{

    List<Customer> findAll();

    List<CustomerDTO> findAllDTO();

    void createCustomer(Customer customer);

    Map<String,String> createCustomerRegex(Customer customer);

    public Map<String,String> editCustomerRegex(Customer customer);

    Customer findCustomerById(String id);

    void editCustomer(Customer customer);

    void deleteCustomer(Integer id);

    List<Customer> searchByName(String name);
}
