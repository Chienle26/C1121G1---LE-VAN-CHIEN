package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumberToText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = sc.nextInt();
        if (number == 0) {
            System.out.println("Zero");
        } else if (number < 10 && number > 0) {
            System.out.println(number10(number));
        } else if (number < 20) {
            System.out.println(number20(number));
        } else if (number < 100) {
            System.out.println(number100(number));
        } else if (number < 1000) {
            System.out.println(number1000(number));
        } else {
            System.out.println("Out of ability");
        }
    }

    public static String number10(int number) {
        String result = "";
        switch (number) {
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            case 3:
                result = "Three";
                break;
            case 4:
                result = "Four";
                break;
            case 5:
                result = "Five";
                break;
            case 6:
                result = "Six";
                break;
            case 7:
                result = "Seven";
                break;
            case 8:
                result = "Eight";
                break;
            case 9:
                result = "Nine";
        }
        return result;
    }

    public static String number20(int number) {
        String result = "";
        switch (number) {
            case 10:
                result = "Ten";
                break;
            case 11:
                result = "Eleven";
                break;
            case 12:
                result = "Twelve";
                break;
            case 13:
                result = "Thirteen";
                break;
            case 14:
                result = "Fourteen";
                break;
            case 15:
                result = "Fifteen";
                break;
            case 16:
                result = "Sixteen";
                break;
            case 17:
                result = "Seventeen";
                break;
            case 18:
                result = "Eighteen";
                break;
            case 19:
                result = "Nineteen";
        }
        return result;
    }

    public static String number100(int number) {
        String result = "";
        int units = number % 10;
        int dozens = number / 10;
        switch (dozens) {
            case 2:
                result = "Twenty ";
                break;
            case 3:
                result = "Thirty ";
                break;
            case 4:
                result = "Forty ";
                break;
            case 5:
                result = "Fifty ";
                break;
            case 6:
                result = "Sixty ";
                break;
            case 7:
                result = "Seventy ";
                break;
            case 8:
                result = "Eighty ";
                break;
            case 9:
                result = "Ninety ";
        }
        result += number10(units);
        return result;
    }

    public static String number1000(int number) {
        String result = "";
        int dozens = number % 100;
        int hundreds = number / 100;
        result += number10(hundreds) + " hundred";
        if (dozens != 0) {
            result += " and " + number100(dozens);
        }
        return result;
    }
}


