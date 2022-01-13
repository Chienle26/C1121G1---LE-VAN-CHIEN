package ss10_stack_queue.exercise.reverse_integer_stack;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseIntegerStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> array = new ArrayList<>(5);
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(array);
        for (Integer element : array) {
            stack.push(element);
        }
        array.clear();
        while (!stack.isEmpty()) {
            array.add(stack.pop());
        }
        System.out.println(array);
    }


}
