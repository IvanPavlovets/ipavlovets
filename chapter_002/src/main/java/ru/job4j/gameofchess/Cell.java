package ru.job4j.gameofchess;


/**
 * Описывает ячеку шахмотной доски.
 */
public class Cell {
    /**
     * расположение ячейки по горизонтали.
     */
    public int x;

    /**
     * расположение ячейки по вертикали.
     */
    public int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
