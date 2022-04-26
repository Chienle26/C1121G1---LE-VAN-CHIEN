package com.chienle.model.contract;

public interface CustomerUseService {
    String getCustomerName();

    String getServiceName();

    Double getServiceCost();

    Double getContractDeposit();

    String getAttachServiceName();

    Double getAttachServiceCost();

    Integer getContractDetailQuantity();

    Double getTotalMoney();
}
