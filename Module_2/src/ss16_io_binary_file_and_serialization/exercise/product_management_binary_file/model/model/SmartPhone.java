package ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.model.model;

public class SmartPhone extends Product {
    private int capacity;

    public SmartPhone() {
    }

    public SmartPhone(int capacity) {
        this.capacity = capacity;
    }

    public SmartPhone(String code, String name, String brand, int capacity, int price) {
        super(code, name, brand, price);
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
        return super.toString() + "SmartPhone{" +
                "capacity=" + capacity +
                '}';
    }
}
