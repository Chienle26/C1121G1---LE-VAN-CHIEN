package ss_case_study_furama_resort.utils;

import ss_case_study_furama_resort.models.model.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        int date = 1;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = sdf.parse(o1.getStartDate());
            Date date2 = sdf.parse(o2.getStartDate());
            Date date3 = sdf.parse(o1.getEndDate());
            Date date4 = sdf.parse(o2.getEndDate());
            if (date1.compareTo(date2) == 0) {
                date = date3.compareTo(date4);
                return date;
            } else {
                date = date1.compareTo(date2);
                return date;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

//Cách 2
//public class BookingComparator implements Comparator<Booking> {
//    @0verride
//    public int compare(Booking o1, Booking o2) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/HM/yyyy");
//        LocalDate startDatel = LocalDate.parse(o1.getStartDate(), formatter);
//        LocalDate startDate2 = LocalDate.parse(o2.getStartDate(), formatter);
//        LocalDate endDatel = LocalDate.parse(o2.getEndDate(), formatter);
//        LocalDate endDate2 = LocalDate.parse(o2.getEndDate(), formatter);
//        if (startDatel.compareTo(startDate2) > 0) {
//            return 1;
//        } else if (startDatel.compareTo(startDate2) < 0) {
//            return -1;
//        } else {
//            if (endDatel.compareTo(endDate2) > 0) {
//                return 1;
//            } else if (endDatel.compareTo(endDate2) < 0) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    }
//}
