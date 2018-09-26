package ru.job4j.gameofchess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.gameofchess.figures.Bishop;
import ru.job4j.gameofchess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования фигуры Bishop.
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopTest {

    private Bishop bishop1 = new Bishop(Cell.C1);


    /**
     * Если фигуры нет в клетке то выкинуть исключение
     */
    @Test
    public void whenFigureNotFoundInCellThenNoMove() {
        Board board = new Board();
        board.add(bishop1);
        Cell source = Cell.A1;
        Cell dest = Cell.C3;
        boolean rst = true;
        try {
        int indexFigure = board.findBy(source);
        Assert.fail("В клетке отсутсвует фигура");
        Figure movableFigure = board.figures[indexFigure];
        Cell[] steps = movableFigure.way(source, dest);
        board.figures[indexFigure] = movableFigure.copy(dest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rst = false;
        }
        assertThat(rst, is(false));
    }

}
