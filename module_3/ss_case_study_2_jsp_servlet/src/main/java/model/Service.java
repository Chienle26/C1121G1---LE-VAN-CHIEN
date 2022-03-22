package model;

public class Service extends Facility{
    private Integer serviceCode;
    private String standardRoom;
    private String description;

    public Service() {
    }

    public Service(Integer serviceCode, String standardRoom, String description) {
        this.serviceCode = serviceCode;
        this.standardRoom = standardRoom;
        this.description = description;
    }

    public Service(String nameService, Double area, Double rentalCosts, Integer maxPeople, Integer rentalType, Integer serviceCode, String standardRoom, String description) {
        super(nameService, area, rentalCosts, maxPeople, rentalType);
        this.serviceCode = serviceCode;
        this.standardRoom = standardRoom;
        this.description = description;
    }

    public Integer getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(Integer serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service{" +
                "nameService='" + nameService + '\'' +
                ", area=" + area +
                ", rentalCosts=" + rentalCosts +
                ", maxPeople=" + maxPeople +
                ", rentalType=" + rentalType +
                ", serviceCode=" + serviceCode +
                ", standardRoom='" + standardRoom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
