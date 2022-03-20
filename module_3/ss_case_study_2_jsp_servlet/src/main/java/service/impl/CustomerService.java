package service.impl;

import model.Customer;
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
    public void createCustomer(Customer customer) {
        this.iCustomerRepo.createCustomer(customer);
    }
}
