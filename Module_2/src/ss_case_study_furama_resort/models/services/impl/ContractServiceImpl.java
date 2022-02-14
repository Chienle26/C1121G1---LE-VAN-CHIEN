package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Booking;
import ss_case_study_furama_resort.models.model.Contract;
import ss_case_study_furama_resort.models.services.IContractService;
import ss_case_study_furama_resort.utils.BookingComparator;

import java.util.*;

public class ContractServiceImpl implements IContractService {
    Scanner scanner = new Scanner(System.in);
    private List<Booking> bookingList = new ArrayList<>(BookingServiceImpl.bookings);
    private Queue<Contract> contracts = new LinkedList<>();

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
                Contract contract = new Contract(bookingList.get(i), deposit, totalPayment, bookingList.get(i));
                contracts.add(contract);
            }
        }
        BookingServiceImpl.bookings = new TreeSet<>();
    }

    @Override
    public void display() {
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }

    @Override
    public void edit() {
        display();
        System.out.println("Nhập mã hợp đồng muốn sửa: ");
        int contractCode = Integer.parseInt(scanner.nextLine());
        for(Contract contract: contracts){
            if (contractCode==contract.getContractNumber()){
                System.out.println("Nhập vào tiền đặt cọc: ");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập vào tổng tiền thanh toán: ");
                double totalPayment = Double.parseDouble(scanner.nextLine());
                contract.setDeposit(deposit);
                contract.setTotalPayment(totalPayment);
            }
        }
    }

    @Override
    public void returnMainMenu() {

    }
}
