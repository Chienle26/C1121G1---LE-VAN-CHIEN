package ss7_abstract_class_interface.exercise.resizeable_interface;

import ss6_inheritance.practice.Circle;
import ss6_inheritance.practice.Rectangle;
import ss6_inheritance.practice.Shape;
import ss6_inheritance.practice.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle(1, 1);
        shapes[2] = new Square(1);

        System.out.println("Area before resize: " + ((Circle) shapes[0]).getArea());
        System.out.println("Area before resize: " + ((Rectangle) shapes[1]).getArea());
        System.out.println("Area before resize: " + ((Square) shapes[2]).getArea());

        for (Shape shape : shapes) {
            ((Resizeable) shape).resize((int) (Math.random() * 100));
        }

        System.out.println("==========================");
        System.out.println("Area after resize " + ((Circle) shapes[0]).getArea());
        System.out.println("Area after resize " + ((Rectangle) shapes[1]).getArea());
        System.out.println("Area after resize " + ((Square) shapes[2]).getArea());

    }
}
