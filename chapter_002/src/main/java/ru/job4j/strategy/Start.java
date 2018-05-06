package ru.job4j.strategy;

public class Start {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape square = new Square();
        Paint paint = new Paint();

        paint.draw(triangle);
        paint.draw(square);

    }
}

