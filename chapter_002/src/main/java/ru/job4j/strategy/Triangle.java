package ru.job4j.strategy;

/**
 * Класс реализует поведение по прорисовки треугольника, реализует интерфейс Shape.
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   ^   \r\n");
        pic.append("  ^ ^  \r\n");
        pic.append(" ^   ^ \r\n");
        pic.append("^^^^^^^\r\n");
        return pic.toString();
    }

}

