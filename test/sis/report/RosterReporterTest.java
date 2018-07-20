package sis.report;

import org.junit.Test;
import sis.studentinfo.CourseSession;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Student;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class RosterReporterTest {

    @Test
    public void testRosterReport() {
        Date startDate = DateUtil.createDate(2003, 1, 6);
        CourseSession session =
                CourseSession.create("ENGL", "101", startDate);
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));

        String rosterReport = new RosterReporter(session).getReport();
        assertEquals(RosterReporter.ROSTER_REPORT_HEADER
                + "A" + RosterReporter.NEWLINE
                + "B" + RosterReporter.NEWLINE
                + RosterReporter.ROSTER_REPORT_FOOTER + "2"
                + RosterReporter.NEWLINE, rosterReport);
    }


}
