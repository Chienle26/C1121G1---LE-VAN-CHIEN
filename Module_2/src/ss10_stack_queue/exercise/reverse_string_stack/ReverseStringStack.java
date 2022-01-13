package ss10_stack_queue.exercise.reverse_string_stack;

import java.util.Stack;

public class ReverseStringStack {
    public static void main(String[] args) {
        Stack<String> wStack = new Stack<>();
        String string = "Le Van Chien";
        String outputString = "";
        System.out.println(string);
        String[] mWord = string.split(" ");
        for (String element : mWord) {
            wStack.push(element);
        }
        System.out.println(wStack);
        while (!wStack.isEmpty()) {
            outputString += wStack.pop() + " ";
        }
        System.out.println(outputString);


    }


}
