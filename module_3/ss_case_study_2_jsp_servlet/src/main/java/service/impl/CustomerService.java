package service.impl;

import model.Customer;
import model.CustomerDTO;
import repository.ICustomerRepo;
import repository.impl.CustomerRepo;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepo iCustomerRepo = new CustomerRepo();
    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepo.findAll();
    }

    @Override
    public List<CustomerDTO> findAllDTO() {
        return iCustomerRepo.findAllDTO();
    }

    @Override
    public void createCustomer(Customer customer) {
        this.iCustomerRepo.createCustomer(customer);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return iCustomerRepo.findCustomerById(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        iCustomerRepo.editCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        iCustomerRepo.deleteCustomer(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return iCustomerRepo.searchByName(name);
    }
}
