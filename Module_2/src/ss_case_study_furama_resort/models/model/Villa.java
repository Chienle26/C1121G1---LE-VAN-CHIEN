package ss_case_study_furama_resort.models.model;

import java.util.Objects;

public class Villa extends Facility {
    private String roomStandard;
    private int poolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String roomStandard, int poolArea, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String nameService, int area, int rentalCosts, int maxPeople, String rentalType, String roomStandard, int poolArea, int numberOfFloors) {
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

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
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
