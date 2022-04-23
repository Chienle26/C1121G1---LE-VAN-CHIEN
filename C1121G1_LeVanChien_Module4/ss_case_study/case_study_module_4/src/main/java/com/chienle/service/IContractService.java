package com.chienle.service;

import com.chienle.model.contract.AttachService;
import com.chienle.model.contract.Contract;
import com.chienle.model.contract.ContractDetail;

import java.util.List;

public interface IContractService {
    List<Contract> findAllContract();

    List<AttachService> findAllAttachService();

    List<ContractDetail> findAllContractDetail();

    void save(Contract contract);

    Contract findById(Integer id);
}
