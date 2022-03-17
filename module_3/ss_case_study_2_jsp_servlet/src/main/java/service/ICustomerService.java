package service;

import model.Customer;

import java.util.List;

public interface ICustomerService extends IService{

    List<Customer> findAll();
}
