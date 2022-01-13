package ss10_stack_queue.exercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập chuỗi cần kiểm tra Backet: ");
            String string = scanner.nextLine();
            Stack<String> bStack = new Stack<>();
            String[] arrString = string.split("");
            Boolean check = true;
            for (String element : arrString) {
                if (element.equals("(")) {
                    bStack.push(element);
                } else if (element.equals(")")) {
                    if (bStack.isEmpty()) {
                        check = false;
                        break;
                    } else if (bStack.peek().equals("(")) {
                        bStack.pop();
                    }
                }
            }
            if (check && bStack.isEmpty()) {
                System.out.println("Well");
            } else {
                System.out.println("Wrong");
            }
        }


    }
}
