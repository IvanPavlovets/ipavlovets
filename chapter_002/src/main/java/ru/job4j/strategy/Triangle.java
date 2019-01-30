package ru.job4j.strategy;

import java.util.StringJoiner;

/**
 * Класс реализует поведение по прорисовки треугольника, реализует интерфейс Shape.
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringJoiner pic = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        pic.add("   ^   ");
        pic.add("  ^ ^  ");
        pic.add(" ^   ^ ");
        pic.add("^^^^^^^");
        return pic.toString();
    }

}

