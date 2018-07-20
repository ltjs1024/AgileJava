package sis.studentinfo;

/**
 * 学生类
 */
public class Student {
    public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    public static final String IN_STATE = "CO";
    private String name;
    private String state="";
    private int credits;

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
}
