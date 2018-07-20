package sis.studentinfo;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CourseSessionTest {
    private static final int CREDITS = 3;
    private CourseSession session;
    private Date startDate;


    @Before
    public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createCourseSession();
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
        assertEquals(CREDITS, firstStudent.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(firstStudent, session.get(0));

        final String secondStudentName = "Coralee DeVaughn";
        final Student secondStudent = new Student(secondStudentName);
        session.enroll(secondStudent);
        assertEquals(CREDITS, secondStudent.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(firstStudent, session.get(0));
        assertEquals(secondStudent, session.get(1));

    }

    @Test
    public void testCourseDates() {
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    @Test
    public void testCount() {
        CourseSession.resetCount();
        createCourseSession();
        assertEquals(1, CourseSession.getCount());
        createCourseSession();
        assertEquals(2, CourseSession.getCount());

    }

    private CourseSession createCourseSession() {
        CourseSession courseSession =
                CourseSession.create("ENGL", "101", startDate);
        courseSession.setNumberOfCredits(CourseSessionTest.CREDITS);

        return courseSession;
    }


}
