package sis.studentinfo;

import org.junit.Test;
import sis.summer.SummerCourseSession;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class SummerCourseSessionTest extends SessionTest {

    @Test
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session =
                createSession(new Course("ENGL", "200"), startDate);
        Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeeksOut, session.getEndDate());
    }

    @Override
    public Session createSession(Course course, Date startDate) {
        return SummerCourseSession.create(course, startDate);
    }
}
