package ru.job4j.inheritance.obj;

/**
 * Класс обертка для строкового параметра диагноза пациента.
 */
public class Diagnose {
    private String diagnose;

    public Diagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    /**
     * геттер доступа строкового парметра diagnose.
     * @return - diagnose.
     */
    public String getDiagnose() {
        return diagnose;
    }

    /**
     * Сеттер для установки праметра diagnose.
     * @param diagnose
     */
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    @Override
    public String toString() {
        return diagnose;
    }
}
