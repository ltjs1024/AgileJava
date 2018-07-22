package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生类
 */
public class Student {

    public enum Grade {
        A(4),
        B(3),
        C(2),
        D(1),
        F(0);

        private final int points;

        Grade(int points) {
            this.points = points;
        }

        public int getPoints() {
            return points;
        }
    }

    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    private List<Grade> grades = new ArrayList<>();
    private String state = "";
    private String name;
    private int credits;
    private double gpa;

    public void setGradingStrategy(GradingStrategy strategy) {
        this.gradingStrategy = strategy;
    }

    public Student(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(int credits) {
        this.credits += credits;
    }

    public boolean isInState() {
        return state.toUpperCase().equals(Student.IN_STATE);
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getGpa() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Grade grade : grades) {
            total += gradingStrategy.getGradePointsFor(grade);
        }
        return total / grades.size();
    }


    public void addGrade(Grade grade) {
        grades.add(grade);
    }


}
