package ss7_abstract_class_interface.exercise.resizeable_interface;

import ss6_inheritance.practice.Circle;
import ss6_inheritance.practice.Rectangle;
import ss6_inheritance.practice.Shape;
import ss6_inheritance.practice.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(1);
        shape[1] = new Rectangle(1, 1);
        shape[2] = new Square(1);

        for (Shape shapes : shape) {
            ((Resizeable) shapes).resize(Math.round(Math.random())*100);
        }

    }
}
