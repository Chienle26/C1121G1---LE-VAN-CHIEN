package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double vnd = 23000;
        double usd;
        System.out.println("Enter USD: ");
        usd = sc.nextDouble();
        double convert = usd * vnd;
        System.out.println("VND = " + convert);
    }
}
