package ss_case_study_furama_resort.controllers;

import ss_case_study_furama_resort.models.model.Employee;
import ss_case_study_furama_resort.models.model.Person;
import ss_case_study_furama_resort.models.services.ICustomerService;
import ss_case_study_furama_resort.models.services.IEmployeeService;
import ss_case_study_furama_resort.models.services.IFacilityService;
import ss_case_study_furama_resort.models.services.impl.CustomerServiceImpl;
import ss_case_study_furama_resort.models.services.impl.EmployeeServiceImpl;
import ss_case_study_furama_resort.models.services.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    static IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    static ICustomerService iCustomerService = new CustomerServiceImpl();
    static IFacilityService iFacilityService = new FacilityServiceImpl();

    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu() {
        boolean flag = true;
        while (flag) {
            System.out.print("Chọn 1 trong các chức năng sau:\n" +
                    "1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    boolean flag1 = true;
                    while (flag1) {
                        System.out.print("Chọn 1 trong các chức năng sau:\n" +
                                "1\tDisplay list employees\n" +
                                "2\tAdd new employee\n" +
                                "3\tEdit employee\n" +
                                "4\tReturn main menu\n");
                        int choose1 = Integer.parseInt(scanner.nextLine());
                        switch (choose1) {
                            case 1:
                                iEmployeeService.display();
                                break;
                            case 2:
                                iEmployeeService.add();
                                break;
                            case 3:
                                iEmployeeService.edit();
                                break;
                            case 4:
                                flag1 = false;
                                break;
                            default:
                                System.out.println("Vui lòng nhập lại!");
                        }
                    }
                    break;
                case 2:
                    boolean flag2 = true;
                    while (flag2) {
                        System.out.print("Chọn 1 trong các chức năng sau:\n" +
                                "1.\tDisplay list customers\n" +
                                "2.\tAdd new customer\n" +
                                "3.\tEdit customer\n" +
                                "4.\tReturn main menu\n");
                        int choose2 = Integer.parseInt(scanner.nextLine());
                        switch (choose2) {
                            case 1:
                                iCustomerService.display();
                                break;
                            case 2:
                                iCustomerService.add();
                                break;
                            case 3:
                                iCustomerService.edit();
                                break;
                            case 4:
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Vui lòng nhập lại!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Chọn 1 trong các chức năng sau:\n" +
                            "1\tDisplay list facility\n" +
                            "2\tAdd new facility\n" +
                            "3\tDisplay list facility maintenance\n" +
                            "4\tReturn main menu\n");
                    int choose3 = Integer.parseInt(scanner.nextLine());
                    switch (choose3) {
                        case 1:
                            iFacilityService.display();
                            break;
                        case 2:
                            System.out.println("Chọn 1 trong các chức năng sau:\n" +
                                    "1.\tAdd New Villa\n" +
                                    "2.\tAdd New House\n" +
                                    "3.\tAdd New Room\n" +
                                    "4.\tBack to menu\n");
                            int chooseAddNewFacility = Integer.parseInt(scanner.nextLine());

                            break;
                        case 3:
                            iCustomerService.edit();
                            break;
                        case 4:
                            flag2 = false;
                            break;
                        default:
                            System.out.println("Vui lòng nhập lại!");
                    }
                    break;
                case 4:
                    System.out.print("Chọn 1 trong các chức năng sau:\n" +
                            "1.\tAdd new booking\n" +
                            "2.\tDisplay list booking\n" +
                            "3.\tCreate new constracts\n" +
                            "4.\tDisplay list contracts\n" +
                            "5.\tEdit contracts\n" +
                            "6.\tReturn main menu\n");
                    break;
                case 5:
                    System.out.print("Chọn 1 trong các chức năng sau:\n" +
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
