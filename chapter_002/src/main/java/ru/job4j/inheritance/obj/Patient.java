package ru.job4j.inheritance.obj;

import ru.job4j.inheritance.obj.Diagnose;

/**
 * Класс пациента.
 */
public class Patient {
    public Diagnose diagnose;

    public Patient(String status) {
        diagnose = new Diagnose(status);
    }

}
