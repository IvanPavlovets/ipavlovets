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

    private Bishop bishop1 = new Bishop(Cell.C1);

    /**
     * Если слон ходит в неправелном направлении то выкинуть исключение
     */
    @Test
    public void whenFigureNotFoundInCellThenNoMove() {
        Board board = new Board();
        board.add(bishop1);
        Cell source = Cell.A1;
        Cell dest = Cell.A3;
        boolean rst = true;
        try {
            int indexFigure = board.findBy(source);
            Figure movableFigure = board.figures[indexFigure];
            Cell[] steps = movableFigure.way(source, dest);
            Assert.fail("Фигура не может так ходить!");
            board.figures[indexFigure] = movableFigure.copy(dest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rst = false;
        }
        assertThat(rst, is(false));
    }

    /**
     * Ход слона с клетки A1 на клетку H8
     */
    @Test
    public void wnenBishopMoveThenMove() {
        Bishop bishop = new Bishop(Cell.A1);
        Cell[] actual = bishop.way(bishop.position, Cell.H8);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(actual, is(expected));
    }

}
