package ss5_access_modifier_static_method_static_property.exercise.access_modifier;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return this.radius;
    }

    double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

}
