package ss6_inheritance.exercise.point_moveable_point_class;

public class Main {
    public static void main(String[] args) {
        //Test Point
        Point point = new Point(5,5);
        System.out.println(point);

        System.out.println("================");
        //Test MovablePoint
        MovablePoint movablePoint = new MovablePoint(10,20);
        System.out.println(movablePoint);
        System.out.println("Move: ");
        movablePoint.move();
    }


}
