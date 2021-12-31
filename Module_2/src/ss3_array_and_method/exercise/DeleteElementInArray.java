package ss3_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("Nhập phần tử cần xóa khỏi mảng: ");
        int elementDel = scanner.nextInt();
        int indexDel=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elementDel) {
                indexDel = i;
                break;
            }
        }
        System.out.println(indexDel);
        for (int i = indexDel; i < arr.length-1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length-1]=0;
        System.out.println(Arrays.toString(arr));

    }
}
