package sis.studentinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public abstract class Session implements Comparable<Session> {
    private final Course course;
    private List<Student> students = new ArrayList<>();
    private Date startDate;
    private int numberOfCredits;
    private URL url;

    protected Session(Course course, Date startDate) {
        this.startDate = startDate;
        this.course = course;
    }

    @Override
    public int compareTo(Session o) {
        int compare = this.getDepartment().compareTo(o.getDepartment());
        if (compare != 0) {
            return compare;
        }
        return this.getNumber().compareTo(o.getNumber());
    }

    public String getDepartment() {
        return course.getDepartment();
    }

    public String getNumber() {
        return course.getNumber();
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student get(int index) {
        return students.get(index);
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    protected Date getStartDate() {
        return startDate;
    }

    protected abstract int getSessionLength();

    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        // weeks * days per week -3 days
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;
        int numberOfDays =
                getSessionLength() * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }


    public void setUrl(String url) throws SessionException {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            log(e);
            throw new SessionException(e);
        }
    }

    private void log(Exception e) {
        e.printStackTrace();
    }

    public URL getUrl() {
        return url;
    }
}
