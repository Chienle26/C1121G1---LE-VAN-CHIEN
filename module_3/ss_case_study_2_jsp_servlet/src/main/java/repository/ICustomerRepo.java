package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepo extends IRepository{
    List<Customer> findAll();
}
