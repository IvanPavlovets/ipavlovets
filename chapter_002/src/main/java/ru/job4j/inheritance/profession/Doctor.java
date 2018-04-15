package ru.job4j.inheritance.profession;

import ru.job4j.inheritance.obj.Diagnose;
import ru.job4j.inheritance.obj.Patient;

/**
 * Класс расширяет клаас Profession.
 */
public class Doctor {

    /**
     * Метод лечить пациента.
     * @param patient
     * @return - диагноз пациента.
     */
    public Diagnose treatPatient(Patient patient){
        return patient.diagnose;
    }

    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        Patient patient = new Patient("грип");
        System.out.println(doctor.treatPatient(patient));
    }
}
