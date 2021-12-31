package ss3_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxInArray2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số hàng của mảng 2D: ");
        int row = scanner.nextInt();
        System.out.print("Nhập vào số cột của mảng 2D: ");
        int col = scanner.nextInt();
        int[][] arr2D = new int[row][col];
        int max = 0;
        String indexMax = "";
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.print("Nhập phần tử thứ " + i + "-" + j + " của mảng: ");
                arr2D[i][j] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arr2D[i]));
        }
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (arr2D[i][j] > max) {
                    max = arr2D[i][j];
                }
            }
        }
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (arr2D[i][j] == max) {
                    indexMax += i + "-" + j + " ";
                }
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng 2D là: " + max + "; Vị trí của nó trong mảng là: " + indexMax);
    }
}
