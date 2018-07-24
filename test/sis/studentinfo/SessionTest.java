package sis.studentinfo;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.Date;

import static org.junit.Assert.*;

public abstract class SessionTest {
    private static final int CREDITS = 3;
    private Session session;
    private Date startDate;


    @Before
    public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createSession();
    }

    public abstract Session createSession(Course course, Date startDate);


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
    public void testComparable() {
        final Date date = new Date();
        Session sessionA = createSession(new Course("CMSC", "101"), date);
        Session sessionB = createSession(new Course("ENGL", "101"), date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

        Session sessionC = createSession(new Course("CMSC", "101"), date);
        assertEquals(0, sessionA.compareTo(sessionC));

        Session sessionD = createSession(new Course("CMSC", "210"), date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);

    }


    private Session createSession() {
        Session Session =
                createSession(new Course("ENGL", "101"), startDate);
        Session.setNumberOfCredits(SessionTest.CREDITS);

        return Session;
    }

    @Test
    public void testSessionUrl() throws SessionException {
        final String url = "http://course.langrsoft.com/cmsc300";
        session.setUrl(url);
        assertEquals(url, session.getUrl().toString());
    }

    @Test
    public void testInvalidSessionUrl() {
        final String url = "httsp://course.langrsoft.com/cmsc300";
        try {
            session.setUrl(url);
            fail("expected exception due to invalid protocol in URL");
        } catch (SessionException expectedException) {
            Throwable cause = expectedException.getCause();
            assertEquals(MalformedURLException.class, cause.getClass());
        }
    }

}
