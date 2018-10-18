package ru.job4j.gameofchess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.gameofchess.figures.Bishop;
import ru.job4j.gameofchess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования фигуры Bishop.
 *
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopTest {

    /**
     * В тесте проверяеться выбрасывание исключения FigureNotFoundException
     * при выборе пустой клетки для хода.
     * Выбраная клетка начала движения фигуры
     * не соответсвует кординате где находиться слон.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundInCellThenNoMove() {
        Board board = new Board();
        Bishop bishop = new Bishop(Cell.C1);
        board.add(bishop);
        board.move(Cell.A1, Cell.A3);
    }

    /**
     * В тесте проверяеться выбрасывание исключения ImposibleMoveException
     * при невозможном ходе слона. Ход не по диагонали.
     */
    @Test(expected = ImposibleMoveException.class)
    public void whenFigureImposibleMoveThenNoMove() {
        Board board = new Board();
        Bishop bishop = new Bishop(Cell.C1);
        board.add(bishop);
        board.move(Cell.C1, Cell.C3);
    }

    /**
     * В тесте проверяеться выбрасывание исключения OccupiedWayException
     * при хождении слоном через занятую клетку.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenCellIsOccupiedThenNoMove() {
        Board board = new Board();
        Bishop bishop1 = new Bishop(Cell.C1);
        Bishop bishop2 = new Bishop(Cell.D2);
        board.add(bishop1);
        board.add(bishop2);
        board.move(Cell.C1, Cell.E3);
    }

    /**
     * Ход слона с клетки A1 на клетку H8
     */
    @Test
    public void wnenBishopMoveToNorthEastThenMove() {
        Bishop bishop = new Bishop(Cell.A1);
        Cell[] actual = bishop.way(bishop.position, Cell.H8);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(actual, is(expected));
    }

    /**
     * Ход слона с клетки H8 на клетку A1
     */
    @Test
    public void wnenBishopMoveToSouthWestThenMove() {
        Bishop bishop = new Bishop(Cell.H8);
        Cell[] actual = bishop.way(bishop.position, Cell.A1);
        Cell[] expected = {Cell.G7, Cell.F6, Cell.E5, Cell.D4, Cell.C3, Cell.B2, Cell.A1};
        assertThat(actual, is(expected));
    }

    /**
     * Ход слона с клетки H1 на клетку A8
     */
    @Test
    public void wnenBishopMoveToNorthWestThenMove() {
        Bishop bishop = new Bishop(Cell.H1);
        Cell[] actual = bishop.way(bishop.position, Cell.A8);
        Cell[] expected = {Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6, Cell.B7, Cell.A8};
        assertThat(actual, is(expected));
    }

    /**
     * Ход слона с клетки A8 на клетку H1
     */
    @Test
    public void wnenBishopMoveToSouthEastThenMove() {
        Bishop bishop = new Bishop(Cell.A8);
        Cell[] actual = bishop.way(bishop.position, Cell.H1);
        Cell[] expected = {Cell.B7, Cell.C6, Cell.D5, Cell.E4, Cell.F3, Cell.G2, Cell.H1};
        assertThat(actual, is(expected));
    }
}
