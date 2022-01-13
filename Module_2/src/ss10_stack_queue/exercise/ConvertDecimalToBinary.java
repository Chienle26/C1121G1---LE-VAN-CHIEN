package ss10_stack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số cần chuyển sang hệ nhị phân: ");
            int decimal = Integer.parseInt(scanner.nextLine());
            int decimalAbs = Math.abs(decimal);
            String binary = "";
            Stack binaryReverse = new Stack();

            while (decimalAbs / 2 >= 0 && decimalAbs != 0) {
                binaryReverse.push(decimalAbs % 2);
                decimalAbs /= 2;
            }
            while (!binaryReverse.isEmpty()) {
                binary += binaryReverse.pop();
            }

            if (decimal > 0) {
                System.out.println(binary);
            } else if (decimal < 0) {
                System.out.println("1 " + binary);
            } else {
                System.out.println(0);
            }
        }
    }

}
