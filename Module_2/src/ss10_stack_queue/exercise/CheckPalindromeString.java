package ss10_stack_queue.exercise;

import java.util.*;

public class CheckPalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi cần kiểm tra Palindrome: ");
        String string = scanner.nextLine();
        string = string.toLowerCase();
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        String[] arrString = string.split("");
        Boolean check = true;
        for (String element : arrString) {
            stack.push(element);
            queue.add(element);
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String isn't Palindrome");
        }

    }
}
