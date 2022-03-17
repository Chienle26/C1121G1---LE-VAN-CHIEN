package model;

public class Villa extends Facility{
    private String roomStandard;
    private Double poolArea;
    private Integer numberOfFloors;

    public Villa() {
    }

    public Villa(String roomStandard, Double poolArea, Integer numberOfFloors) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String nameService, Double area, Double rentalCosts, Integer maxPeople, String rentalType, String roomStandard, Double poolArea, Integer numberOfFloors) {
        super(nameService, area, rentalCosts, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean equals(Object o) {
        Villa villa = (Villa) o;
        return this.getNameService().equals(villa.getNameService());
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String getStringFacility() {
        return super.getStringFacility() + "," + this.roomStandard + "," + this.poolArea + "," + this.numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "nameService='" + nameService + '\'' +
                ", area=" + area +
                ", rentalCosts=" + rentalCosts +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
