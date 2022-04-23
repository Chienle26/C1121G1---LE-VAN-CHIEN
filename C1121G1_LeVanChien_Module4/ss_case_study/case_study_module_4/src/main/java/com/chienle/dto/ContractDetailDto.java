package com.chienle.dto;

import com.chienle.model.contract.AttachService;
import com.chienle.model.contract.Contract;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ContractDetailDto {

    private Integer contractDetailId;

    private Integer quantity;

    private AttachService attachService;

    private Contract contract;

    public ContractDetailDto() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
