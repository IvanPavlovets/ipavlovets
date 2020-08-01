package ru.job4j.inputOutput;

/**
 * Класс принимает входящие аргументы метода main. ArgZip разбивает входной массив на параметры.
 */
public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        return false;
    }

    public String directory() {
        return null;
    }

    public String exclude() {
        return null;
    }

    public String output() {
        return null;
    }
}
