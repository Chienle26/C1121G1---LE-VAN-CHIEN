package com.chienle.service;

import com.chienle.model.contract.AttachService;
import com.chienle.model.contract.Contract;
import com.chienle.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> findAllContract();

    Page<Contract> findAllCustomerUseService(Pageable pageable, String keywordValue);

    List<AttachService> findAllAttachService();

    List<ContractDetail> findAllContractDetail();

    void save(Contract contract);

    void save(ContractDetail contractDetail);

    Contract findById(Integer id);
}
