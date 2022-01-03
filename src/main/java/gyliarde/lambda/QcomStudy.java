package gyliarde.lambda;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class QcomStudy {

    class Student implements Comparable<Student> {
        private double score;
        private double gradeYear;

        public Student(double score, double gradeYear ) {
            this.score = score;
            this.gradeYear = gradeYear;
        }

        public double getGradeYear() {
            return gradeYear;
        }

        public double getScore() {
            return score;
        }

        @Override
        public int compareTo(Student student) {
            return (this.getScore() < student.getScore()) ? -1 : ((this.getScore() == student.getScore()) ? 0 : 1);
        }

    };

    // Approach 1
    @Test
    public void shouldHandleScoreStudentsWithoutLambda() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(10.0,2011));
        students.add(new Student(20.0,2010));
        students.add(new Student(15.0,2011));

        double highestScore = 0.0;
        for (Student s : students ) {
            if (s.getGradeYear() == 2011) {
                if (s.getScore() > highestScore) {
                    highestScore = s.score;
                }
            }
        }

        System.out.println(highestScore);
    }

    // Approach 2
    @Test
    public void shouldHandleScoreStudentsWithLamba() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(10.0,2011));
        students.add(new Student(20.0,2011));
        students.add(new Student(15.0,2011));

        Double highestScore = students.stream()
                .filter(student -> student.getGradeYear() == 2011)
                .map(student -> student.getScore()).max(Comparator.comparing(Double::doubleValue)).get();

        System.out.println(highestScore);
    }


}
