package sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSession {
    private static int count = 0;

    private String department;
    private String number;
    private Date startDate;
    private ArrayList<Student> students = new ArrayList<>();
    private int numberOfCredits;

    public static CourseSession create(String department,
                                       String number,
                                       Date startDate) {
        incrementCount();
        return new CourseSession(department, number, startDate);
    }

    private CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
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


    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    public Student get(int index) {
        return students.get(index);
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        // weeks * days per week -3 days
        final int sessionLength = 16;
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;
        int numberOfDays =
                sessionLength * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }


    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
}
