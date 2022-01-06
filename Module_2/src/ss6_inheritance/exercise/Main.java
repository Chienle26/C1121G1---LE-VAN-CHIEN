package ss6_inheritance.exercise;

public class Main {
    public static void main(String[] args) {
        //Circle Test
        Circle circle = new Circle(5, "Green");
        System.out.println(circle);

        System.out.println("============================================");
        //Cylinder Test
        Cylinder cylinder = new Cylinder(10, "Blue", 10);
        System.out.println(cylinder);
    }
}
