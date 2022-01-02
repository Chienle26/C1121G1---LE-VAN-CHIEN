package ss3_array_and_method.exercise;

import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi bất kỳ: ");
        String str = scanner.nextLine();
        int count = 0;
        System.out.println("Nhập vào ký tự muốn kiểm tra số lần xuất hiện trong chuỗi: ");
        char chars = scanner.next().charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == chars) {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của ký tự '" + chars + "' trong chuỗi là: " + count);
    }
}
