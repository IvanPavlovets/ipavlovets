package ru.job4j.gameofchess;

import ru.job4j.gameofchess.figures.Figure;

public class Board {

    /**
     * Индекс фигуры.
     */
    private int indexOfFigure = 0;

    /**
     * Количество фигур на шахматной доске.
     */
    Figure[] figures = new Figure[32];

    /**
     * Добовляет фигуру на доску.
     * @param figure - добовляемая фигура.
     */
    void add(Figure figure) {
        figures[indexOfFigure++] = figure;
    }

    /**
     * Метод перемещения фигуры.
     * В методе организуеться серия проверок которые выявляют
     * можно ли сделать ход фигурой. Затем происходит передвижение фигуры
     * с начальной клетки до клетки, куда ходим.
     * В конечном итоге в ячейку записываеться новое положение фигуры (метод copy)
     * или пораждаеться одна из трех возможных исключительных ситаций.
     *
     * Метод проверяет что в заданой ячейки есть фигура,
     * в противном случае FigureNotFoundException.
     *
     * Если фигура есть то проверка на то может ли фигура так двигаться,
     * в противном случае ImposibleMoveException.
     *
     * Если возвращеный ход в виде клеток занят фигурами то OccupiedWayException.
     * Если клетки свободны то записать в ячейку новое положение фигуры, методом copy.
     * @param source
     * @param dest
     * @return
     * @throws ImposibleMoveException - возникает в случае если возможный ход проходит через занятые ячейки другими ячейками
     * @throws OccupiedWayException - возникает если фигура не может совершить данное движение
     * @throws FigureNotFoundException - возникает в случае если в заданой ячейки нет фигуры
     */
    public boolean move(Cell source, Cell dest) {
        boolean result = true;
        int index = this.findBy(source);
        try {
            //Figure figureToMove = figures[indexFigure];
            Cell[] steps = figures[index].way(source, dest);
            for (Cell cell : steps) {
                if (figureInCell(cell)) {
                    throw new OccupiedWayException("Клетка занята");
                }
            }
            figures[index] = figures[index].copy(dest);
        } catch (ImposibleMoveException e) {
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }

    public int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index < this.figures.length; index++) {
            if (figures[index] != null && figures[index].position.x == cell.x && figures[index].position.y == cell.y) {
                rst = index;
                break;
            }
        }
        if (rst == -1) {
            throw new FigureNotFoundException("В клетке отсутсвует фигура");
        }
        return rst;
    }

    /**
     * Проверяет наличие ячейки в клетке.
     * @param dest проверяемая ячейка.
     * @return Результат проверки.
     */
    private boolean figureInCell(Cell dest) {
        boolean result = false;
        for (int i = 0; i < this.figures.length; i++) {
            if (figures[i] != null && figures[i].position.x == dest.x && figures[i].position.y == dest.y) {
                result = true;
                break;
            }
        }
        return result;
    }
}

