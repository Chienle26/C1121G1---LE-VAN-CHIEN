package ss_case_study_furama_resort.controllers;

import ss_case_study_furama_resort.models.services.*;
import ss_case_study_furama_resort.models.services.impl.*;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    static IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    static ICustomerService iCustomerService = new CustomerServiceImpl();
    static IFacilityService iFacilityService = new FacilityServiceImpl();
    static IBookingService iBookingService = new BookingServiceImpl();
    static IContractService iContactService = new ContractServiceImpl();
    static IPromotionManagement iPromotionManagement = new PromotionManagementServiceImpl();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        boolean flagMainMenu = true;
        int chooseMainMenu = 0;
        while (flagMainMenu) {
            System.out.print("Chọn 1 trong các chức năng sau:\n" +
                    "1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            try {
                chooseMainMenu = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
            }
            switch (chooseMainMenu) {
                case 1:
                    boolean flagEmployeeMenu = true;
                    int chooseEmloyeeMenu = 0;
                    while (flagEmployeeMenu) {
                        System.out.print("Chọn 1 trong các chức năng sau:\n" +
                                "1\tDisplay list employees\n" +
                                "2\tAdd new employee\n" +
                                "3\tEdit employee\n" +
                                "4\tReturn main menu\n");
                        try {
                            chooseEmloyeeMenu = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
                        }
                        switch (chooseEmloyeeMenu) {
                            case 1:
                                iEmployeeService.display();
                                break;
                            case 2:
                                try {
                                    iEmployeeService.add();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                iEmployeeService.edit();
                                break;
                            case 4:
                                flagEmployeeMenu = false;
                                break;
                            default:
                                System.out.println("Vui lòng nhập lại!");
                        }
                    }
                    break;
                case 2:
                    boolean flagCustomerMenu = true;
                    int chooseCustomerMenu = 0;
                    while (flagCustomerMenu) {
                        System.out.print("Chọn 1 trong các chức năng sau:\n" +
                                "1.\tDisplay list customers\n" +
                                "2.\tAdd new customer\n" +
                                "3.\tEdit customer\n" +
                                "4.\tReturn main menu\n");
                        try {
                            chooseCustomerMenu = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
                        }
                        switch (chooseCustomerMenu) {
                            case 1:
                                iCustomerService.display();
                                break;
                            case 2:
                                try {
                                    iCustomerService.add();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                iCustomerService.edit();
                                break;
                            case 4:
                                flagCustomerMenu = false;
                                break;
                            default:
                                System.out.println("Vui lòng nhập lại!");
                        }
                    }
                    break;
                case 3:
                    boolean flagFacilityMenu = true;
                    int chooseFacilityMenu = 0;
                    while (flagFacilityMenu) {
                        System.out.print("Chọn 1 trong các chức năng sau:\n" +
                                "1\tDisplay list facility\n" +
                                "2\tAdd new facility\n" +
                                "3\tDisplay list facility maintenance\n" +
                                "4\tReturn main menu\n");
                        try {
                            chooseFacilityMenu = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
                        }
                        switch (chooseFacilityMenu) {
                            case 1:
                                iFacilityService.display();
                                break;
                            case 2:
                                boolean flagAddService = true;
                                int chooseAddNewFacility = 0;
                                while (flagAddService) {
                                    System.out.print("Chọn 1 trong các chức năng sau:\n" +
                                            "1.\tAdd New Villa\n" +
                                            "2.\tAdd New House\n" +
                                            "3.\tAdd New Room\n" +
                                            "4.\tBack to menu\n");
                                    try {
                                        chooseAddNewFacility = Integer.parseInt(scanner.nextLine());
                                    } catch (Exception e) {
                                        System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
                                    }
                                    switch (chooseAddNewFacility) {
                                        case 1:
                                            iFacilityService.addVilla();
                                            break;
                                        case 2:
                                            iFacilityService.addHouse();
                                            break;
                                        case 3:
                                            iFacilityService.addRoom();
                                            break;
                                        case 4:
                                            flagAddService = false;
                                            break;
                                        default:
                                            System.out.println("Vui lòng chọn lại!");
                                    }
                                }
                                break;
                            case 3:
                                iFacilityService.displayFacilityMaintenance();
                                break;
                            case 4:
                                flagFacilityMenu = false;
                                break;
                            default:
                                System.out.println("Vui lòng nhập lại!");
                        }
                    }
                    break;
                case 4:
                    boolean flagBooking = true;
                    int chooseBookingMenu = 0;
                    while (flagBooking) {
                        System.out.print("Chọn 1 trong các chức năng sau:\n" +
                                "1.\tAdd new booking\n" +
                                "2.\tDisplay list booking\n" +
                                "3.\tCreate new constracts\n" +
                                "4.\tDisplay list contracts\n" +
                                "5.\tEdit contracts\n" +
                                "6.\tReturn main menu\n");
                        try {
                            chooseBookingMenu = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
                        }
                        switch (chooseBookingMenu) {
                            case 1:
                                try {
                                    iBookingService.add();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                iBookingService.display();
                                break;
                            case 3:
                                try {
                                    iContactService.add();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 4:
                                iContactService.display();
                                break;
                            case 5:
                                iContactService.edit();
                                ;
                                break;
                            case 6:
                                flagBooking = false;
                                break;
                            default:
                                System.out.println("Vui lòng nhập lại!");
                        }
                    }
                    break;
                case 5:
                    boolean flagPromotion = true;
                    int choosePromotion = 0;
                    while (flagPromotion) {
                        System.out.print("Chọn 1 trong các chức năng sau:\n" +
                                "1.\tDisplay list customers use service\n" +
                                "2.\tDisplay list customers get voucher\n" +
                                "3.\tReturn main menu\n");
                        try {
                            choosePromotion = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
                        }
                        switch (choosePromotion) {
                            case 1:
                                iPromotionManagement.displayCustomersUseService();
                                break;
                            case 2:
                                iPromotionManagement.displayCustomersGetVoucher();
                                break;
                            case 3:
                                flagPromotion = false;
                                break;
                            default:
                                System.out.println("Vui lòng nhập lại!");
                        }
                    }
                    break;
                case 6:
                    flagMainMenu = false;
                    break;
                default:
                    System.out.println("Xin mời bạn chọn lại");
            }
        }
    }
}
