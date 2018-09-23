package ru.job4j.gameofchess;

public class ImposibleMoveException extends RuntimeException {
    public ImposibleMoveException(String message) {
        super(message);
    }
}
