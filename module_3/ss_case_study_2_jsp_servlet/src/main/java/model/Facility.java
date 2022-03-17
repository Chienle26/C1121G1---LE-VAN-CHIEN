package model;

public abstract class Facility {
    String nameService;
    Double area;
    Double rentalCosts;
    Integer maxPeople;
    String rentalType;

    public Facility() {
    }

    public Facility(String nameService, Double area, Double rentalCosts, Integer maxPeople, String rentalType) {
        this.nameService = nameService;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getStringFacility() {
        return this.nameService + "," + this.area + "," + this.rentalCosts + "," + this.maxPeople + "," + this.rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "nameService='" + nameService + '\'' +
                ", area=" + area +
                ", rentalCosts=" + rentalCosts +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
