package sis.studentinfo;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class SessionTest {
    private static final int CREDITS = 3;
    private Session session;
    private Date startDate;


    @Before
    public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createSession();
    }

    public abstract Session createSession(String department,
                                          String number,
                                          Date startDate);


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
        Session sessionA = createSession("CMSC", "101", date);
        Session sessionB = createSession("ENGL", "101", date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);

        Session sessionC = createSession("CMSC", "101", date);
        assertEquals(0, sessionA.compareTo(sessionC));

        Session sessionD = createSession("CMSC", "210", date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);

    }


    private Session createSession() {
        Session Session =
                createSession("ENGL", "101", startDate);
        Session.setNumberOfCredits(SessionTest.CREDITS);

        return Session;
    }


}
