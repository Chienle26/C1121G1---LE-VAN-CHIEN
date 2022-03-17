package model;

public class Booking {
    String bookingCode;
    String startDate;
    String endDate;
    String customerCode;
    String nameService;
    String serviceType;

    public Booking() {
    }

    public Booking(String bookingCode, String startDate, String endDate, String customerCode, String nameService, String serviceType) {
        this.bookingCode = bookingCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.nameService = nameService;
        this.serviceType = serviceType;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStringBooking() {
        return this.bookingCode + "," + this.startDate + "," + this.endDate + "," + this.customerCode + "," + this.nameService + "," + this.serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode=" + bookingCode +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customerCode=" + customerCode +
                ", nameService='" + nameService + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(Booking o) {
//        return this.bookingCode - o.bookingCode;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        Booking booking = (Booking) o;
//        return this.getBookingCode().equals(booking.getBookingCode());
//    }
//
//    @Override
//    public int hashCode() {
//        return 1;
//    }
}
