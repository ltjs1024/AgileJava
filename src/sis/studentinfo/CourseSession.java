package sis.studentinfo;

import java.util.Date;

public class CourseSession extends Session {
    private static int count = 0;

    public static CourseSession create(Course course,
                                       Date startDate) {
        return new CourseSession(course, startDate);
    }

    protected CourseSession(Course course, Date startDate) {
        super(course, startDate);
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
