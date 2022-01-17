package ss12_search_algorithm.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class FindStringLargestAscending {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập chuỗi cần tìm: ");
//        String string = scanner.nextLine();
        String string = "Welcome";
        LinkedList<Character> chars = new LinkedList<>();
        chars.add(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            for (int j = 0; j < chars.size(); j++) {
                if (string.charAt(i) > chars.getLast()) {
                    chars.add(string.charAt(i));
                }
            }
        }
        for (Character str : chars) {
            System.out.print(str);
        }
    }
}
    /* Tính toán độ phức tạp của bài toán:
            * 	1 vòng lặp bên ngoài = n;
            * 	1 vòng lặp bên trong = n - 1;
            *  1 câu lệnh = 1
           	*  1 vòng lặp * 1 câu lệnh = 1;
            *  T(n) = (n * (n - 1)) + (1 + 1);
            *  T(n) = O(n^2) + O(n);
            * 	T(n) = O(n^2);
            * 	=> Độ phức tạp bài toán này là O(n^2) */
