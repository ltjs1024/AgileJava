package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.studentinfo.CourseSessionTest;
import sis.studentinfo.DateUtilTest;
import sis.report.RosterReporterTest;
import sis.studentinfo.StudentTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        StudentTest.class,
        CourseSessionTest.class,
        RosterReporterTest.class,
        DateUtilTest.class,
})
public class AllTests {
}
