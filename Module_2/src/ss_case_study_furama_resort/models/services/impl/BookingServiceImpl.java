package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Booking;
import ss_case_study_furama_resort.models.services.IBookingService;
import ss_case_study_furama_resort.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    Scanner scanner = new Scanner(System.in);
    public static Set<Booking> bookings = new TreeSet<>();

    static {
        bookings.add(new Booking(11111, "06/01/2022", "07/01/2022", 1234, "HillVilla", "Villa"));
        bookings.add(new Booking(33333, "01/01/2022", "05/01/2022", 5678, "DeluxRoom", "Room"));
        bookings.add(new Booking(22222, "01/01/2022", "02/01/2022", 2345, "WhiteHouse", "House"));
        bookings.add(new Booking(11111, "01/01/2022", "02/01/2022", 2345, "WhiteHouse", "House"));
    }

    @Override
    public void add() {
        System.out.print("Nhập mã Booking: ");
        int bookingCode = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập ngày bắt đầu Booking: ");
        String startDate = scanner.nextLine();
        System.out.print("Nhập ngày kết thúc Booking: ");
        String endDate = scanner.nextLine();
        System.out.println();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.display();
        System.out.println();
        System.out.print("Nhập mã khách hàng Booking: ");
        int customerCode = Integer.parseInt(scanner.nextLine());
        System.out.println();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.display();
        System.out.println();
        System.out.print("Nhập tên dịch vụ Booking: ");
        String nameService = scanner.nextLine();
        System.out.print("Nhập loại dịch vụ Booking: ");
        String serviceType = scanner.nextLine();
        bookings.add(new Booking(bookingCode,startDate,endDate,customerCode,nameService,serviceType));
        System.out.println("Thêm mới booking thành công!");
    }

    @Override
    public void display() {
        List<Booking> bookingList = new ArrayList<>(bookings);
        Collections.sort(bookingList, new BookingComparator());
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void returnMainMenu() {

    }

}
