package sis.report;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Student;

import java.util.ArrayList;
import java.util.List;

public class RosterReporter {
    public static final String NEWLINE = System.lineSeparator();
    public static final String ROSTER_REPORT_HEADER
            = "Student" + NEWLINE + "---" + NEWLINE;
    public static final String ROSTER_REPORT_FOOTER
            = NEWLINE + "# students = ";
    private final CourseSession session;

    public RosterReporter(CourseSession session) {
        this.session = session;
    }

    public String getReport() {
        StringBuilder res = new StringBuilder();
        writeHeader(res);
        writeBody(res);
        writeFooter(res);

        return res.toString();
    }

    private void writeHeader(StringBuilder res) {
        res.append(ROSTER_REPORT_HEADER);
    }

    private void writeBody(StringBuilder res) {
        final List<Student> students = session.getAllStudents();
        for (Student student : students) {
            res.append(student.getName());
            res.append(NEWLINE);
        }
    }

    private void writeFooter(StringBuilder res) {
        res.append(ROSTER_REPORT_FOOTER);
        res.append(session.getAllStudents().size() + NEWLINE);
    }
}
