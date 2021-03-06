package ru.job4j.gameofchess.figures;

import ru.job4j.gameofchess.Cell;
import ru.job4j.gameofchess.ImposibleMoveException;

public class Bishop extends Figure {

    /**
     * Конструктор по умолчанию который принимает позицию
     * @param position - кординаты фигуры на шахматной доске
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * В методе происходи проверка хода слона по диагонали,
     * затем в цикле идет "накопление" пройденых фигурой ячеек в массиве steps.
     * @param source - текущая кордината фигуры.
     * @param dest - ячека куда ходит фигура.
     * @return - массив пройденых ячеек.
     * @throws ImposibleMoveException
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImposibleMoveException("Фигура не может так ходить!");
        }
        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
        int deltaX = Integer.compare(dest.x, source.x);
        int deltaY = Integer.compare(dest.y, source.y);
        int stepX = 0;
        int stepY = 0;
        for (int i = 1; i <= steps.length; i++) {
            stepX = source.x + (deltaX * i);
            stepY = source.y + (deltaY * i);
            steps[i - 1] = findCell(stepX, stepY);
        }
        return steps;
    }

    /**
     * Метод проверяет происходит ли передвижение фигуры по диагонали.
     * Диагональ определяеться тем что x должен быть равен y по модулю.
     * @param source - начальная точка расположения фигуры.
     * @param dest - конечная точка расположение фигуры.
     * @return - возвращает true или false в зависимости от условия,
     * по диагонали фигура или нет.
     */
    private boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(dest.y - source.y) == Math.abs(dest.x - source.x)) {
            return true;
        }
        return false;
    }


    /**
     * Создает новый экземпляр фигуры с новый расположением.
     * @param dest - кординта хода фигуры.
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}

