package sis.summer;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Session;

import java.util.Date;

public class SummerCourseSession extends Session {

    private SummerCourseSession(String department,
                                String number,
                                Date startDate) {
        super(department, number, startDate);
    }

    public static Session create(
            String department,
            String number,
            Date startDate) {
        return new SummerCourseSession(department, number, startDate);
    }

    @Override
    protected int getSessionLength() {
        return 8;
    }


}
