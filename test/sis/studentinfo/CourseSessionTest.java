package sis.studentinfo;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CourseSessionTest extends SessionTest {

    @Override
    public Session createSession(Course course, Date startDate) {
        return CourseSession.create(course, startDate);
    }


    @Test
    public void testCourseDates() {
        Date startDate = DateUtil.createDate(2003, 1, 6);
//        Session session = createSession(new Course("ENGL", "200"), startDate);
        Session session = createSession(createCourse(), startDate);
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    private Course createCourse() {
        return new Course("ENGL", "200");
    }

    @Test
    public void testCount() {
        CourseSession.resetCount();
        createSession(createCourse(), new Date());
        assertEquals(1, CourseSession.getCount());
        createSession(createCourse(), new Date());
        assertEquals(2, CourseSession.getCount());

    }


}
