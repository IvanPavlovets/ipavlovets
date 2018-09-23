package ru.job4j.gameofchess;

public class FigureNotFoundException extends RuntimeException {

    public FigureNotFoundException(String message) {
        super(message);
    }
}
