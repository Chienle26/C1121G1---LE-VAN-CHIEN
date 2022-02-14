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
        int date=1;
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
