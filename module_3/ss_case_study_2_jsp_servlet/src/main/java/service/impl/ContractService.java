package service.impl;

import model.Contract;
import repository.IContractRepo;
import repository.impl.ContractRepo;

import java.util.List;

public class ContractService implements service.IContractService {
    IContractRepo iContractRepo = new ContractRepo();
    @Override
    public List<Contract> findAll() {
        return this.iContractRepo.findAll();
    }
}
