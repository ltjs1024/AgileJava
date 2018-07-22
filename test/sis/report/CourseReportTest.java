package sis.report;

import org.junit.Test;
import sis.studentinfo.CourseSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static sis.report.RosterReporter.NEWLINE;

public class CourseReportTest {

    @Test
    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create("ENGL", "101", date));
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL", "410", date));
        report.add(CourseSession.create("CZEC", "220", date));
        report.add(CourseSession.create("ITAL", "330", date));

        assertEquals(
                "CZEC 200" + NEWLINE
                        + "CZEC 220" + NEWLINE
                        + "ENGL 101" + NEWLINE
                        + "ITAL 330" + NEWLINE
                        + "ITAL 410" + NEWLINE,
                report.text()
        );
    }

    @Test
    public void testSortStringsInPlace() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Heller");
        list.add("Kafka");
        list.add("Camus");
        list.add("Boyle");

        ArrayList<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        assertEquals("Boyle", sortedList.get(0));
        assertEquals("Camus", sortedList.get(1));
        assertEquals("Heller", sortedList.get(2));
        assertEquals("Kafka", sortedList.get(3));


        assertEquals("Heller", list.get(0));
        assertEquals("Kafka", list.get(1));
        assertEquals("Camus", list.get(2));
        assertEquals("Boyle", list.get(3));
    }

    @Test
    public void testStringCompareTo() {
        assertTrue("A".compareTo("B") < 0);
        assertEquals(0, "A".compareTo("A"));
        assertTrue("B".compareTo("A") > 0);
    }


}
