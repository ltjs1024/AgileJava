package sis.studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CourseSession extends Session {
    private static int count = 0;

    public static CourseSession create(String department,
                                       String number,
                                       Date startDate) {
        return new CourseSession(department, number, startDate);
    }

    protected CourseSession(String department, String number, Date startDate) {
        super(department, number, startDate);
        CourseSession.incrementCount();
    }

    private static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void resetCount() {
        count = 0;
    }


    protected int getSessionLength() {
        return 16;
    }


}
