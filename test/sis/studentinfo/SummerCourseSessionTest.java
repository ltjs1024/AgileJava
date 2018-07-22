package sis.studentinfo;

import org.junit.Test;
import sis.studentinfo.DateUtil;
import sis.summer.SummerCourseSession;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class SummerCourseSessionTest extends SessionTest {

    @Test
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session =
                createSession("ENGL", "200", startDate);
        Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeeksOut, session.getEndDate());
    }

    @Override
    public Session createSession(String department, String number, Date startDate) {
        return SummerCourseSession.create(department,number,startDate);
    }
}