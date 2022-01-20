package ss_extra_exercise.vehicle_management.model.model;

public class Motorcycle extends Vehicle {
    int capacity;

    public Motorcycle() {
    }

    public Motorcycle(int capacity) {
        this.capacity = capacity;
    }

    public Motorcycle(String licensePlates, String brandName, int yearOfManufacture, String owner, int capacity) {
        super(licensePlates, brandName, yearOfManufacture, owner);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "capacity=" + capacity +
                ", licensePlates='" + licensePlates + '\'' +
                ", brandName='" + brandName + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", Owner='" + Owner + '\'' +
                '}';
    }
}
