package ss_extra_exercise.vehicle_management.model.model;

public abstract class Vehicle {
    String licensePlates;
    String brandName;
    int yearOfManufacture;
    String Owner;

    public Vehicle() {
    }

    public Vehicle(String licensePlates, String brandName, int yearOfManufacture, String owner) {
        this.licensePlates = licensePlates;
        this.brandName = brandName;
        this.yearOfManufacture = yearOfManufacture;
        this.Owner = owner;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlates='" + licensePlates + '\'' +
                ", brandName='" + brandName + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", Owner='" + Owner + '\'' +
                '}';
    }
}
