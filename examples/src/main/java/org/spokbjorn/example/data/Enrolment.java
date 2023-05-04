package org.spokbjorn.example.data;

import java.util.List;

public record Enrolment(
        Student student,
        Course course,
        Grade grade
) {

    public static List<Enrolment> sample() {
        return List.of(
                new Enrolment(
                        new Student("John", 21, "male"),
                        new Course("Math", 60),
                        new Grade(65)
                ),
                new Enrolment(
                        new Student("Jane", 20, "female"),
                        new Course("Math", 60),
                        new Grade(70)
                ),
                new Enrolment(
                        new Student("Peter", 24, "male"),
                        new Course("Programming", 65),
                        new Grade(50)
                )
        );
    }

}
