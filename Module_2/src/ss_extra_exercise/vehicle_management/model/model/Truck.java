package ss_extra_exercise.vehicle_management.model.model;

public class Truck {
    int weight;

    public Truck() {
    }

    public Truck(int weight) {
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
                '}';
    }
}
