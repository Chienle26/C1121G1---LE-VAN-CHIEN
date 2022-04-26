package com.chienle.repository.contract;

import com.chienle.model.contract.Contract;
import com.chienle.model.contract.CustomerUseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByCustomer_CustomerNameContaining(Pageable pageable, String keyword);

    @Query(value = "select customer.customer_name as customerName, service.service_name as serviceName, service.service_cost as serviceCost, contract.contract_deposit as contractDeposit, attach_service.attach_service_name as attachServiceName,attach_service.attach_service_cost as attachServiceCost, contract_detail.quantity as contractDetailQuantity " +
            ", ( ifnull(service.service_cost,0) - ifnull(contract.contract_deposit,0) +( ifnull(attach_service.attach_service_cost,0) * ifnull(contract_detail.quantity,0)) ) as totalMoney " +
            "from contract " +
            "join customer on customer.customer_id = contract.customer_id " +
            "join service on service.service_id = contract.service_id " +
            "left join contract_detail on contract_detail.contract_id = contract.contract_id " +
            "left join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id;", nativeQuery = true)
    <T> List<T> findCustomerUseService(Class<T> classType);
}
