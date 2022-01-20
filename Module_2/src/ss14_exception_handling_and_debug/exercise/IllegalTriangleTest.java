package ss14_exception_handling_and_debug.exercise;

import java.util.Scanner;

public class IllegalTriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        do {
            flag = false;
            try {
                System.out.print("Nhập độ dài cạnh thứ nhất: a = ");
                int a = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập độ dài cạnh thứ hai: b = ");
                int b = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập độ dài cạnh thứ ba: c = ");
                int c = Integer.parseInt(scanner.nextLine());
                System.out.println(checkIllegalTriangle(a, b, c));
            } catch (IllegalTriangleException e) {
                flag = true;
                e.printStackTrace();
            } finally {
                System.out.println("------------------------------->");
            }
        }
        while (flag);
    }

    public static String checkIllegalTriangle(int a, int b, int c) throws IllegalTriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("Cạnh của tam giác không được âm, vui lòng nhập lại");
        } else if (a + b < c || b + c < a || a + c < b) {
            throw new IllegalTriangleException("Tổng 2 cạnh của tam giác không được nhỏ hơn cạnh còn lại, vui lòng nhập lại");
        }
        return "Độ dài 3 cạnh nhập vào là độ dài 3 cạnh của một tam giác";
    }
}
