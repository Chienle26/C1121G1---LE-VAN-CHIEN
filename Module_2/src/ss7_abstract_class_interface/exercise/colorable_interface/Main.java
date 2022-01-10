package ss7_abstract_class_interface.exercise.colorable_interface;

import ss6_inheritance.practice.Circle;
import ss6_inheritance.practice.Rectangle;
import ss6_inheritance.practice.Shape;
import ss6_inheritance.practice.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(5);
        shapes[1] = new Rectangle(2, 3);
        shapes[2] = new Circle(2);
        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                System.out.println("Area Square: " + shape.getArea());
                ((Colorable) shape).howToColor();
                System.out.println("===================");
            } else if (shape instanceof Rectangle) {
                System.out.println("Area Rectangle: " + shape.getArea());
                System.out.println("===================");

            } else {
                System.out.println("Area Circle: " + shape.getArea());
                System.out.println("===================");
            }
        }
    }
}
