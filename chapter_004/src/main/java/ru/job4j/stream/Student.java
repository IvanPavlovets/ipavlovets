package ru.job4j.stream;

import java.util.Objects;

public class Student {
    public int score;
    public String surname;

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

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(score, surname);
    }
}
