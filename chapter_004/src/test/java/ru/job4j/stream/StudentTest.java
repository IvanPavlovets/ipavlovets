package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void when10AThenResult() {
        Student student = new Student();
        List<Student> result = student.levelOf(Arrays.asList(new Student(3, "33"),
                null,
                null,
                new Student(1, "11"),
                new Student(2, "22"),
                new Student(5, "55"),
                new Student(4, "44")), 3);

        List<Student> expected = Arrays.asList(new Student(5, "55"),
                new Student(4, "44")
        );
        assertThat(result, is(expected));
    }
}
