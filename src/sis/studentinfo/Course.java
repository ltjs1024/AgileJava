package sis.studentinfo;

public class Course {
    private final String department;
    private final String number;

    public Course(String department, String number) {
        this.department = department;
        this.number = number;

    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Course other = (Course) obj;
        return department.equals(other.department)
                && number.equals(other.number);
    }

    @Override
    public int hashCode() {
        final int hashMultiplier = 41;
        int result = 7;
        result = result * hashMultiplier + department.hashCode();
        result = result * hashMultiplier + number.hashCode();

        return result;
    }
}
