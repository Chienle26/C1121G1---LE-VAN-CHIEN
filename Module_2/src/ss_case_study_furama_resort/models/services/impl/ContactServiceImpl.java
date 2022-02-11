package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Booking;
import ss_case_study_furama_resort.models.model.Contact;
import ss_case_study_furama_resort.models.services.IContactService;
import ss_case_study_furama_resort.utils.BookingComparator;

import java.util.*;

public class ContactServiceImpl implements IContactService {
    Scanner scanner = new Scanner(System.in);
    private List<Booking> bookingList = new ArrayList<>(BookingServiceImpl.bookings);
    private Queue<Contact> contacts = new LinkedList<>();

    @Override
    public void add() {
        bookingList = new ArrayList<>(BookingServiceImpl.bookings);
        Collections.sort(bookingList, new BookingComparator());
        for (int i = 0; i < bookingList.size(); i++) {
            if (!bookingList.get(i).getServiceType().equals("Room")) {
                System.out.println("Nhập vào tiền đặt cọc của hợp đồng có mã booking là " + bookingList.get(i).getBookingCode() + ": ");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập vào tổng tiền thanh toán của hợp đồng có mã booking là " + bookingList.get(i).getBookingCode() + ": ");
                double totalPayment = Double.parseDouble(scanner.nextLine());
                Contact contact = new Contact(bookingList.get(i), deposit, totalPayment, bookingList.get(i));
                contacts.add(contact);
            }
        }
        BookingServiceImpl.bookings = new TreeSet<>();
    }

    @Override
    public void display() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    @Override
    public void edit() {
        display();
        System.out.println("Nhập mã hợp đồng muốn sửa: ");
        int contactCode = Integer.parseInt(scanner.nextLine());
        for(Contact contact: contacts){
            if (contactCode==contact.getContractNumber()){
                System.out.println("Nhập vào tiền đặt cọc: ");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập vào tổng tiền thanh toán: ");
                double totalPayment = Double.parseDouble(scanner.nextLine());
                contact.setDeposit(deposit);
                contact.setTotalPayment(totalPayment);
            }
        }
    }

    @Override
    public void returnMainMenu() {

    }
}
