package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

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

    /**
     * В тетсе в цикле заполнються коллекции List и Map.
     * Проверяеться преобразование list в Map, путем их равенсва.
     */
    @Test
    public void whenCalltoMapThenGetMapOfStudent() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        Map<String, Student> expected = new TreeMap<String, Student>();
        for (int i = 0; i <= 50; i += 10) {
            students.add(new Student(i, "styd" + i));
            expected.put("styd" + i, new Student(i, "styd" + i));
        }
        Map<String, Student> result = school.toMap(students);
        assertThat(result, is(expected));
    }

}
