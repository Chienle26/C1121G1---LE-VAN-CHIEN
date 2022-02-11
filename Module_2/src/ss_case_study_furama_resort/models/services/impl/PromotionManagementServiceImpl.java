package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Booking;
import ss_case_study_furama_resort.models.services.IPromotionManagement;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class PromotionManagementServiceImpl implements IPromotionManagement {
    Scanner scanner = new Scanner(System.in);


    @Override
    public void displayCustomersUseService() {
        System.out.print("Nhập năm cần hiển thị danh sách Booking: ");
        int yearBooking = Integer.parseInt(scanner.nextLine());
        String year = Integer.toString(yearBooking);
        for (Booking booking:BookingServiceImpl.bookings){
            if (booking.getStartDate().indexOf(year)>0||booking.getEndDate().indexOf(year)>0){
                System.out.println(booking);
            }
        }
    }

    @Override
    public void displayCustomersGetVoucher() {
        Stack<Booking> stack = new Stack<>();
//        String date = java.util.Date.
    }
}
