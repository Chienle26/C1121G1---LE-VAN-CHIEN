package ss3_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinInArray2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số hàng của mảng 2D: ");
        int row = scanner.nextInt();
        System.out.print("Nhập vào số cột của mảng 2D: ");
        int col = scanner.nextInt();
        int[][] arr2D = new int[row][col];
        String indexMin = "";
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.print("Nhập phần tử thứ " + i + "-" + j + " của mảng: ");
                arr2D[i][j] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arr2D[i]));
        }
        int min = arr2D[0][0];
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (arr2D[i][j] < min) {
                    min = arr2D[i][j];
                }
            }
        }
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (arr2D[i][j] == min) {
                    indexMin += i + "-" + j;
                }
            }
        }
        System.out.println("Giá trị nhỏ nhất trong mảng 2D là: " + min + "; Vị trí của nó trong mảng là: " + indexMin);
    }
}
