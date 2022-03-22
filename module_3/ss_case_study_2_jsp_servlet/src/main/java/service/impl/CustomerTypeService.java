package service.impl;

import model.CustomerType;
import repository.ICustomerTypeRepo;
import repository.impl.CustomerTypeRepo;
import service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    ICustomerTypeRepo iCustomerTypeRepo = new CustomerTypeRepo();
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepo.findAll();
    }
}
