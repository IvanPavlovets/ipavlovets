package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
    public int score;
    public String surname;

    public Student() {
    }

    public Student(int score) {
        this.score = score;
    }

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{"
                +
                "score="
                +
                score
                +
                ", surname='"
                +
                surname
                +
                '\''
                +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(score, surname);
    }

    @Override
    public int compareTo(Student o) {
        return this.score > o.getScore() ? -1 : 1;
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(t -> Stream.ofNullable(t)).sorted()
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        Student student = new Student();
        List<Student> studentList = student.levelOf(Arrays.asList(new Student(3, "33"),
                null,
                null,
                new Student(1, "11"),
                new Student(2, "22"),
                new Student(5, "55"),
                new Student(4, "44")), 3);

        System.out.println(studentList);

    }
}
