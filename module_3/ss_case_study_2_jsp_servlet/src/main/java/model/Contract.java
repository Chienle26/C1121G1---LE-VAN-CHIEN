package model;

public class Contract {
    private Integer contractNumber;
    private Booking bookingCode;
    private double deposit;
    private double totalPayment;
    private Booking customerCode;

    private static Integer number =1;


    public Contract() {
    }

    public Contract(Booking bookingCode, double deposit, double totalPayment, Booking customerCode) {
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerCode = customerCode;
        this.contractNumber = number++;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
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

    public static Integer getNumber() {
        return number;
    }

    public static void setNumber(Integer number) {
        Contract.number = number;
    }

    public String getStringContract() {
        return this.contractNumber + "," + this.bookingCode.bookingCode + "," + this.deposit + "," + this.totalPayment + "," + this.customerCode.customerCode;
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
