package sis.studentinfo;

public class BasicGradingStrategy {
    public static int gradePointsFor(Student.Grade grade) {
        if (Student.Grade.A == grade) return 4;
        if (Student.Grade.B == grade) return 3;
        if (Student.Grade.C == grade) return 2;
        if (Student.Grade.D == grade) return 1;
        return 0;
    }
}
