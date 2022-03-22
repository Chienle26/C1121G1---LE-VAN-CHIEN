package model;

public class House extends Facility {
    private String roomStandard;
    private Integer numberOfFloors;

    public House() {
    }

    public House(String roomStandard, Integer numberOfFloors) {
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String nameService, Double area, Double rentalCosts, Integer maxPeople, Integer rentalType, String roomStandard, Integer numberOfFloors) {
        super(nameService, area, rentalCosts, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean equals(Object o) {
        House house = (House) o;
        return this.getNameService().equals(house.getNameService());
    }

    @Override
    public int hashCode() {
        return 3;
    }

    @Override
    public String getStringFacility() {
        return super.getStringFacility() + "," + this.roomStandard + "," + this.numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "nameService='" + nameService + '\'' +
                ", area=" + area +
                ", rentalCosts=" + rentalCosts +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
