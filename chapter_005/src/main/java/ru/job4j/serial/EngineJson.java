package ru.job4j.serial;

import javax.xml.bind.annotation.XmlAttribute;

public class EngineJson {
    private final String name;
    private final int number;

    public EngineJson(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "EngineJson{"
                + "name='" + name + '\''
                + ", number=" + number + '}';
    }
}
