package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.report.CourseReportTest;
import sis.report.RosterReporterTest;
import sis.studentinfo.CourseSessionTest;
import sis.studentinfo.DateUtilTest;
import sis.studentinfo.StudentTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        CourseSessionTest.class,
        DateUtilTest.class,
        StudentTest.class,
        CourseReportTest.class,
        RosterReporterTest.class,
})
public class AllTests {
}
