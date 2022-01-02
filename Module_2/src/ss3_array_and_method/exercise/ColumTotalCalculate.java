package ss3_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ColumTotalCalculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số hàng của mảng 2D: ");
        int row = scanner.nextInt();
        System.out.print("Nhập vào số cột của mảng 2D: ");
        int col = scanner.nextInt();
        int[][] arr2D = new int[row][col];
        int columTotal = 0;
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.print("Nhập phần tử thứ " + i + "-" + j + " của mảng: ");
                arr2D[i][j] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arr2D[i]));
        }
        System.out.println("Nhập vào thứ tự cột cần tính tổng: ");
        int colum = scanner.nextInt();
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (j == colum) {
                    columTotal += arr2D[i][j];
                }
            }
        }
        System.out.println("Tổng các giá trị của cột thứ  " + colum + " là : " + columTotal);
    }
}
