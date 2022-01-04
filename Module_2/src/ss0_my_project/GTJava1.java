package ss0_my_project;

import java.util.Arrays;

public class GTJava1 {
    public static void main(String[] args) {
        int[] arr1 = {7, 2, 5, 3, 5, 3};
        int[] arr2 = {7, 2, 5, 4, 6, 3, 5, 3};
        int[] arr3 = new int[arr1.length];
        boolean check;
        int index = 0;
        int j;
        for (int i = 0; i < arr2.length; i++) {
            check = true;
            for (j = 0; j < arr1.length; j++) {
                if (arr2[j] == arr1[i]) {
                    check = false;
                    break;
                }
            }
            if (check) {

                arr3[index] = arr2[i];
                index+=1;
            }
        }
        System.out.println(Arrays.toString(arr3));
    }
}
