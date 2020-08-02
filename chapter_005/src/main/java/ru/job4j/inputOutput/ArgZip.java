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
        boolean result = false;
        if (args.length == 3) {
            result = true;
        }
        return result;
    }

    public String directory() {
        String[] tokens = args[0].split("=");
        return tokens[1];
    }

    public String exclude() {
        String[] tokens = args[1].split("=");
        return tokens[1];
    }

    public String output() {
        String[] tokens = args[2].split("=");
        return tokens[1];
    }
}
