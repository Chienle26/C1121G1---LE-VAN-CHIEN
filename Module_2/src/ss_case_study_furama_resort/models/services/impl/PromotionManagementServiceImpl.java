package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Booking;
import ss_case_study_furama_resort.models.services.IPromotionManagement;

import java.text.SimpleDateFormat;
import java.util.*;

public class PromotionManagementServiceImpl implements IPromotionManagement {
    Scanner scanner = new Scanner(System.in);


    @Override
    public void displayCustomersUseService() {
        System.out.print("Nhập năm cần hiển thị danh sách Booking: ");
        int yearBooking = Integer.parseInt(scanner.nextLine());
        String year = Integer.toString(yearBooking);
        for (Booking booking : BookingServiceImpl.bookings) {
            if (booking.getStartDate().indexOf(year) > 0 || booking.getEndDate().indexOf(year) > 0) {
                System.out.println(booking);
            }
        }
    }

    @Override
    public void displayCustomersGetVoucher() {
        Stack<Booking> bookingStack = new Stack<>();
        Map<String,Integer> voucher = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateNow = sdf.format(date);
        dateNow = dateNow.substring(3);
        System.out.println("Nhập số lượng voucher khuyến mãi 10%: ");
        int voucher10 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng voucher khuyến mãi 20%: ");
        int voucher20 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng voucher khuyến mãi 50%: ");
        int voucher50 = Integer.parseInt(scanner.nextLine());
        voucher.put("voucher10",voucher10);
        voucher.put("voucher20",voucher20);
        voucher.put("voucher50",voucher50);
        for (Booking booking : BookingServiceImpl.bookings) {
            if (booking.getStartDate().substring(3).equals(dateNow)||booking.getEndDate().substring(3).equals(dateNow)) {
                bookingStack.add(booking);
            }
        }
    }
}
