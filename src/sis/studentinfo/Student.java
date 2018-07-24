package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 学生类
 */
public class Student {


    public static final String TOO_MANY_NAME_PARTS_MSG =
            "Student name '%s' contains more than %d parts";
    public static final int MAX_NAME_PARTS = 3;
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    public static Logger logger = Logger.getLogger(Student.class.getName());

    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    private List<Grade> grades = new ArrayList<>();
    private String state = "";
    private String name;
    private int credits;
    private double gpa;
    private String id;

    public void setGradingStrategy(GradingStrategy strategy) {
        this.gradingStrategy = strategy;
    }

    public Student(final String fullName) {
        this.name = fullName;
        credits = 0;
        List<String> nameParts = split(fullName);
        if (nameParts.size() > MAX_NAME_PARTS) {
            String message = String.format(TOO_MANY_NAME_PARTS_MSG,
                    fullName, MAX_NAME_PARTS);
            Student.logger.info(message);
            throw new StudentNameFormatExcption(message);
        }
        setName(nameParts);
    }

    private void log(String message) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info(message);
    }

    private List<String> split(String fullName) {
        String[] split = fullName.split(" ");
        List<String> results = new ArrayList<>();
        for (String name : split) {
            results.add(name);
        }
        return results;
    }

    private void setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty()) {
            this.firstName = name;
        } else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }

    private String removeLast(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        return list.remove(list.size() - 1);
    }


    public String getName() {
        return name;
    }

    private String firstName = "";
    private String middleName = "";
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
