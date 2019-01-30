package ru.job4j.strategy;

/**
 * Класс контекст принимающий различные виды поведений
 * классов интерфейса Shape и выполняющий их.
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }
}
