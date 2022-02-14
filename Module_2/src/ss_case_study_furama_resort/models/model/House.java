package ss_case_study_furama_resort.models.model;

public class House extends Facility{
    private String roomStandard;
    private int numberOfFloors;

    public House() {
    }

    public House(String roomStandard, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String nameService, int area, int rentalCosts, int maxPeople, String rentalType, String roomStandard, int numberOfFloors) {
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

    public int getNumberOfFloors() {
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
