package ss14_exception_handling_and_debug.exercise;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
        super("Some error");
    }

    public IllegalTriangleException(String message) {
        super(message);
    }

}
