package ss_case_study_furama_resort.models.model;

public class Contract {
    private int contractNumber;
    private Booking bookingCode;
    private double deposit;
    private double totalPayment;
    private Booking customerCode;

    private static int number =1;


    public Contract() {
    }

    public Contract(Booking bookingCode, double deposit, double totalPayment, Booking customerCode) {
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerCode = customerCode;
        this.contractNumber = number++;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Booking getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(Booking bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Booking getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Booking customerCode) {
        this.customerCode = customerCode;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Contract.number = number;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", bookingCode=" + bookingCode.getBookingCode() +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", customerCode=" + customerCode.getCustomerCode() +
                '}';
    }
}
