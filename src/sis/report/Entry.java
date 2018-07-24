package sis.report;

import sis.studentinfo.Student;

import java.util.Objects;

public class Entry {

    private final Student.Grade grade;
    private final String message;

    public Entry(Student.Grade grade, String message) {
        this.grade = grade;
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Entry other = (Entry) obj;
        return this.grade == other.grade
                && this.message.equals(other.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, message);
    }
}
