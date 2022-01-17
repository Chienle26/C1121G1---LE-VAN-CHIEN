package ss_extra_exercise.vehicle_management.model.model;

public class Car {
    int numberOfSeats;
    String vehicleType;

    public Car() {
    }

    public Car(int numberOfSeats, String vehicleType) {
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeats=" + numberOfSeats +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
