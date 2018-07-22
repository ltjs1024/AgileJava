package sis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.report.CourseReportTest;
import sis.report.ReportCardTest;
import sis.report.RosterReporterTest;
import sis.studentinfo.*;
import sis.studentinfo.SummerCourseSessionTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        CourseSessionTest.class,
        DateUtilTest.class,
        StudentTest.class,
        CourseReportTest.class,
        RosterReporterTest.class,
        ReportCardTest.class,
        BasicGradingStrategyTest.class,
        HonorsGradingStrategyTest.class,
        SummerCourseSessionTest.class

})
public class AllTests {
}
