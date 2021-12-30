package ss2_loop_in_java.bai_tap;

import java.util.Scanner;

public class PrintImage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose = -1;
        do {
            System.out.println("Menu: ");
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle");
            System.out.println("3.Print isosceles triangle");
            System.out.println("4.Exit");
            System.out.print("Enter number: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Enter width: ");
                    int width = sc.nextInt();
                    System.out.print("Enter height: ");
                    int height = sc.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Enter height: ");
                    height = sc.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = height; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 1; i <= height; i++) {
                        for (int k = height; k > i; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = height; i > 0; i--) {
                        for (int k = height; k > i; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Enter height: ");
                    height = sc.nextInt();
                    for (int i = 1; i <= height; i++) {
                        for (int k = height; k > i; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= 2 * i - 1; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        } while (choose != 4);
    }
}