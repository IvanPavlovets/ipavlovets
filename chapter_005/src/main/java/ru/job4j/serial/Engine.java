package ru.job4j.serial;

public class Engine {
    private final String name;
    private final int number;

    public Engine(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Engine{"
                +
                "name='" + name + '\''
                +
                ", number=" + number + '}';
    }
}
