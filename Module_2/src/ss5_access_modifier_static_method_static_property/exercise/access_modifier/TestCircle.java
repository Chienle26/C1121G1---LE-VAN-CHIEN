package ss5_access_modifier_static_method_static_property.exercise.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Radius = " + circle.getRadius());
        System.out.println("Area = " + circle.getArea());
    }
}
