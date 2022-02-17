package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Booking;
import ss_case_study_furama_resort.models.services.IBookingService;
import ss_case_study_furama_resort.utils.BookingComparator;
import ss_case_study_furama_resort.utils.ReadAndWriteFileCSV;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    Scanner scanner = new Scanner(System.in);
    public static Set<Booking> bookingSet = new TreeSet<>();

    @Override
    public void add() {
        int bookingCode=0;
        int customerCode=0;
        try {
            System.out.print("Nhập mã Booking: ");
            bookingCode = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
        }
        System.out.print("Nhập ngày bắt đầu Booking: ");
        String startDate = scanner.nextLine();
        System.out.print("Nhập ngày kết thúc Booking: ");
        String endDate = scanner.nextLine();
        System.out.println();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.display();
        System.out.println();
        try {
            System.out.print("Nhập mã khách hàng Booking: ");
            customerCode = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại!");
        }
        System.out.println();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.display();
        System.out.println();
        System.out.print("Nhập tên dịch vụ Booking: ");
        String nameService = scanner.nextLine();
        System.out.print("Nhập loại dịch vụ Booking: ");
        String serviceType = scanner.nextLine();
        bookingSet = new TreeSet<>();
        bookingSet.add(new Booking(bookingCode, startDate, endDate, customerCode, nameService, serviceType));
        ReadAndWriteFileCSV.writeBookingToCSV(bookingSet,ReadAndWriteFileCSV.BOOKING_FILE,true);
        ReadAndWriteFileCSV.writeBookingToCSV(bookingSet,ReadAndWriteFileCSV.BOOKING_FILE_COPY,true);
        System.out.println("Thêm mới booking thành công!");
    }

    @Override
    public void display() {
        bookingSet = ReadAndWriteFileCSV.readBookingToCSV(ReadAndWriteFileCSV.BOOKING_FILE);
        List<Booking> bookingList = new ArrayList<>(bookingSet);
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
