package repository;

import model.Contract;

import java.util.List;

public interface IContractRepo {
    List<Contract> findAll();
}
