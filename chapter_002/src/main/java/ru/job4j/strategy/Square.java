package ru.job4j.strategy;

/**
 * Класс реализует поведение по прорисовки квадрата, реализует интерфейс Shape.
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append(" +++++\n");
        pic.append("+     +\n");
        pic.append("+     +\n");
        pic.append(" +++++");
        return pic.toString();
    }
}

