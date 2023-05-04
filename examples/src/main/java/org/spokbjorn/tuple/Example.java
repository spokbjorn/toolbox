package org.spokbjorn.tuple;

import java.util.stream.Stream;
import org.spokbjorn.example.data.Enrolment;

public class Example {

    public static void main(String[] args) {
        // the var keyword is very useful as the types can be very long
        Stream<Triad<String, String, Boolean>> namesWithCourseAndIsPassingGrade = Enrolment.sample()
                .stream()
                .map(enrolment ->
                        Tuple.of(
                                enrolment.student().name(),
                                enrolment.course().name(),
                                enrolment.grade().grade() >= enrolment.course().passingGrade()));
        // var would be List<Duad<String, String>>
        var namesWithCourseWhichPassed = namesWithCourseAndIsPassingGrade
                .filter(Triad::third)
                .map(nameWithCourseAndIsPassingGrade ->
                        Tuple.of(
                                nameWithCourseAndIsPassingGrade.first(),
                                nameWithCourseAndIsPassingGrade.second()))
                .toList();
        namesWithCourseWhichPassed.forEach(nameWithCourseWhichPassed ->
                System.out.println("%s passed %s".formatted(nameWithCourseWhichPassed.first(), nameWithCourseWhichPassed.second())));
    }

}
