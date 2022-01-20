package ss_extra_exercise.vehicle_management.model.model;

public class Truck extends Vehicle {
    int weight;

    public Truck() {
    }

    public Truck(int weight) {
        this.weight = weight;
    }

    public Truck(String licensePlates, String brandName, int yearOfManufacture, String owner, int weight) {
        super(licensePlates, brandName, yearOfManufacture, owner);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "weight=" + weight +
                ", licensePlates='" + licensePlates + '\'' +
                ", brandName='" + brandName + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", Owner='" + Owner + '\'' +
                '}';
    }
}
