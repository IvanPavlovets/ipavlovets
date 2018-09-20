package ru.job4j.gameOfChess;

public abstract class Figure {

    public final Cell position = null;

    public Figure() {
    }

    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        return new Cell[0];
    }

    public Figure copy(Cell dest){
        return new Bishop(dest);
    }
}
