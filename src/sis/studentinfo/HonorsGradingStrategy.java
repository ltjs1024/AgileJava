package sis.studentinfo;

public class HonorsGradingStrategy implements GradingStrategy {

    @Override
    public int getGradePointsFor(Student.Grade grade) {
        int points = BasicGradingStrategy.gradePointsFor(grade);
        if (points > 0) {
            points += 1;
        }
        return points;
    }


}
