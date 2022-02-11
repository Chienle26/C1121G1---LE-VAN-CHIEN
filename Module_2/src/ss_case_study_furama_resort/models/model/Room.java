package ss_case_study_furama_resort.models.model;

public class Room extends Facility{
    String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String nameService, int area, int rentalCosts, int maxPeople, String rentalType, String freeService) {
        super(nameService, area, rentalCosts, maxPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public boolean equals(Object o) {
        Room room = (Room) o;
        return this.getNameService().equals(room.getNameService());
    }

    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public String toString() {
        return "Room{" +
                "nameService='" + nameService + '\'' +
                ", area=" + area +
                ", rentalCosts=" + rentalCosts +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                ", freeService='" + freeService + '\'' +
                '}';
    }
}
