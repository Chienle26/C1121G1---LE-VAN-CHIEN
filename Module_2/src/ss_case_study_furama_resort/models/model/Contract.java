package ss_case_study_furama_resort.models.model;

public class Contract {
    int contractNumber;
    int bookingCode;
    int deposit;
    int totalPayment;
    int customerCode;

    public Contract() {
    }

    public Contract(int contractNumber, int bookingCode, int deposit, int totalPayment, int customerCode) {
        this.contractNumber = contractNumber;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerCode = customerCode;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", bookingCode=" + bookingCode +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", customerCode=" + customerCode +
                '}';
    }
}
