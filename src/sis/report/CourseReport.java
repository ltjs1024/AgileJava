package sis.report;

import sis.studentinfo.CourseSession;

import java.util.ArrayList;
import java.util.Collections;

import static sis.report.RosterReporter.NEWLINE;

public class CourseReport {
    private ArrayList<CourseSession> sessions = new ArrayList<>();

    public void add(CourseSession session) {
        sessions.add(session);
    }

    public String text() {
        Collections.sort(sessions);
        StringBuilder res = new StringBuilder();
        for (CourseSession session : sessions) {
            res.append(session.getDepartment());
            res.append(" ");
            res.append(session.getNumber());
            res.append(NEWLINE);
        }
        return res.toString();
    }
}
