package com.chienle.dto;

import com.chienle.model.service_entity.RentType;
import com.chienle.model.service_entity.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.ConstraintViolation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;

public class ServiceDto implements Validator {

    private Integer serviceId;

    @Pattern(regexp = "^(DV-)[0-9]{4}$", message = "invalid code Ex: DV-0000")
    private String serviceCode;

    @NotBlank(message = "must no be blank")
    private String serviceName;

//    @Min(value = 0)
    private Integer serviceArea;

//    @Min(value = 0)
    private Double serviceCost;

//    @Min(value = 0)
    private Integer serviceMaxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;

//    @NotNull
//    @Min(value = 0)
    private Double poolArea;

//    @NotNull
//    @Min(value = 0)
    private Integer numberOfFloors;

    private RentType rentType;

    private ServiceType serviceType;

    public ServiceDto() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        ServiceDto serviceDto = (ServiceDto) target;
//        if (serviceDto.getServiceArea() <= 0){
//            errors.rejectValue("serviceArea","std.serviceAre","serviceArea phải lớn hơn 0");
//        }
    }
}
