package ss_case_study_furama_resort.controllers;

import ss_case_study_furama_resort.models.model.Employee;
import ss_case_study_furama_resort.models.model.Person;
import ss_case_study_furama_resort.models.services.IEmployeeService;

import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
//    IEmployeeService iEmployeeService = new Employee();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("Chọn 1 trong các chức năng sau:\n" +
                    "1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Chọn 1 trong các chức năng sau:\n" +
                            "1\tDisplay list employees\n" +
                            "2\tAdd new employee\n" +
                            "3\tEdit employee\n" +
                            "4\tReturn main menu\n");
                    int choose1 = Integer.parseInt(scanner.nextLine());
                    switch (choose1){
                        case 1:
                            break;
                        case 2:

                    }
                    break;
                case 2:
                    System.out.println("Chọn 1 trong các chức năng sau:\n" +
                            "1.\tDisplay list customers\n" +
                            "2.\tAdd new customer\n" +
                            "3.\tEdit customer\n" +
                            "4.\tReturn main menu\n");
                    break;
                case 3:
                    System.out.println("Chọn 1 trong các chức năng sau:\n" +
                            "1\tDisplay list facility\n" +
                            "2\tAdd new facility\n" +
                            "3\tDisplay list facility maintenance\n" +
                            "4\tReturn main menu\n");
                    break;
                case 4:
                    System.out.println("Chọn 1 trong các chức năng sau:\n" +
                            "1.\tAdd new booking\n" +
                            "2.\tDisplay list booking\n" +
                            "3.\tCreate new constracts\n" +
                            "4.\tDisplay list contracts\n" +
                            "5.\tEdit contracts\n" +
                            "6.\tReturn main menu\n");
                    break;
                case 5:
                    System.out.println("Chọn 1 trong các chức năng sau:\n" +
                            "1.\tDisplay list customers use service\n" +
                            "2.\tDisplay list customers get voucher\n" +
                            "3.\tReturn main menu\n");
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Xin mời bạn chọn lại");
            }
        }
    }

}
