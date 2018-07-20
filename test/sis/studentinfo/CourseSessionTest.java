package sis.studentinfo;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CourseSessionTest {

    private CourseSession session;
    private Date startDate;


    @Before
    public void setUp() {
        startDate = new DateUtil().createDate(2003, 1, 6);
        session = new CourseSession("ENGL", "101", startDate);
    }


    @Test
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }

    @Test
    public void testEnrollStudents() {
        final String firstStudentName = "Cain DiVoe";
        final Student firstStudent = new Student(firstStudentName);
        session.enroll(firstStudent);
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(firstStudent, session.get(0));

        final String secondStudentName = "Coralee DeVaughn";
        final Student secondStudent = new Student(secondStudentName);
        session.enroll(secondStudent);
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(firstStudent, session.get(0));
        assertEquals(secondStudent, session.get(1));

    }

    @Test
    public void testCourseDates() {
        Date sixteenWeeksOut = new DateUtil().createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }


}
