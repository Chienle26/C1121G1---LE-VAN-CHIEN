package ss2_loop_in_java.bai_tap;

import java.util.Scanner;

public class Print20FirstPrimeNumber {
    public static void main(String[] args) {
        Boolean check = true;
        int count = 0;
        int i = 2;
        while (count < 20) {
            check = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
}
