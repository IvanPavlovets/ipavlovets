package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class School {
    List<Student> collect(List<Student> students, Predicate<Student> redicate) {
        List<Student> studs = students.stream().filter(
                redicate
        ).collect(Collectors.toList());
        return studs;
    }

    Map<String, Student> toMap(List<Student> students) {
        Map<String, Student> studs = students.stream(
        ).collect(Collectors.toMap(
                e -> e.getSurname(),
                e -> e));
        return studs;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i <= 50; i += 10) {
            students.add(new Student(i, "styd" + i));
        }

        System.out.println(students);

        School school = new School();
        System.out.println(school.toMap(students));

        System.out.println("10A: " + school.collect(students, student -> student.score > 70));
        System.out.println("10B: " + school.collect(students, student -> student.score >= 50 && student.score <= 70));
        System.out.println("10C: " + school.collect(students, student -> student.score < 50));

    }
}
