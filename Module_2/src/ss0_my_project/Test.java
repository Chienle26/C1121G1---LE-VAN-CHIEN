package ss0_my_project;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexNameService = "^[A-Z]{1}[a-z]+$";
        Boolean isNameServiceVilla;
        String nameServiceVilla;
        do {
            System.out.print("Nhập tên Villa: ");
            nameServiceVilla = scanner.nextLine();
            isNameServiceVilla = nameServiceVilla.matches(regexNameService);
            System.out.println(isNameServiceVilla);
        } while (!isNameServiceVilla);
    }


    //        public static void main(String[] args)
//        {
//            String obj = "abcdef";
//            int length = obj.length();
//            char c[] = new char[length];
//            obj.getChars(0, length, c, 0);
//            CharArrayReader input1 = new CharArrayReader(c);
//            CharArrayReader input2 = new CharArrayReader(c, 0, 3);
//            int i;
//            try {
//                while ((i = input2.read()) != -1) {
//                    System.out.print((char) i);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//    public static void main(String[] args) {
//        String obj = "abcdefgh";
//        int length = obj.length();
//        char c[] = new char[length];
//        obj.getChars(0, length, c, 0);
//        CharArrayReader input1 = new CharArrayReader(c);
//        CharArrayReader input2 = new CharArrayReader(c, 1, 4);
//        int i;
//        int j;
//        try {
//            while ((i = input1.read()) == (j = input2.read())) {
//                System.out.print((char) i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

