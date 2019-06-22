package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void when10AThenResult() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i <= 100; i += 10) {
            students.add(new Student(i));
        }
        List<Student> result = school.collect(students, student -> student.score > 70);
        List<Student> expected = Arrays.asList(new Student(80),
                new Student(90), new Student(100)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void when10BThenResult() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i <= 100; i += 10) {
            students.add(new Student(i));
        }
        List<Student> result = school.collect(students, student -> student.score >= 50 && student.score <= 70);
        List<Student> expected = Arrays.asList(new Student(50),
                new Student(60), new Student(70)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void when10CThenResult() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i <= 100; i += 10) {
            students.add(new Student(i));
        }
        List<Student> result = school.collect(students, student -> student.score < 50);
        List<Student> expected = Arrays.asList(new Student(0),
                new Student(10), new Student(20),
                new Student(30), new Student(40)
        );
        assertThat(result, is(expected));
    }
}
