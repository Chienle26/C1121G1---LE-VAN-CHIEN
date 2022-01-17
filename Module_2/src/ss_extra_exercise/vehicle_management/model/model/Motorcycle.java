package ss_extra_exercise.vehicle_management.model.model;

public class Motorcycle {
    int capacity;

    public Motorcycle() {
    }

    public Motorcycle(int capacity) {
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
                '}';
    }
}
