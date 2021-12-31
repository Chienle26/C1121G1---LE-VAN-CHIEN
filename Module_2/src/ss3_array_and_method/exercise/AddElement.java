package ss3_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
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
        System.out.print("Nhập phần tử cần thêm vào mảng: ");
        int elementAdd = scanner.nextInt();
        System.out.print("Nhập vị trí phần tử cần thêm vào mảng: ");
        int indexAdd = scanner.nextInt();
        if (indexAdd <= -1 || indexAdd >= arr.length - 1) {
            System.out.println("Không chèn được phần tử vào mảng");
        } else {
            int[] newArr = new int[arr.length + 1];
            Boolean check = false;
            for (int i = 0; i < newArr.length; i++) {
                if (check) {
                    newArr[i] = arr[i - 1];
                } else {
                    newArr[i] = arr[i];
                }
                if (i == indexAdd) {
                    newArr[i] = elementAdd;
                    check = true;
                }
            }
            System.out.println(Arrays.toString(newArr));
        }

    }
}
