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
     *
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
     * <p>
     * Метод проверяет что в заданой ячейки есть фигура,
     * в противном случае FigureNotFoundException.
     * <p>
     * Если фигура есть то проверка на то может ли фигура так двигаться,
     * в противном случае ImposibleMoveException.
     * <p>
     * Если возвращеный ход в виде клеток занят фигурами то OccupiedWayException.
     * Если клетки свободны то записать в ячейку новое положение фигуры, методом copy.
     *
     * @param source
     * @param dest
     * @return
     * @throws ImposibleMoveException  - возникает в случае если возможный ход проходит через занятые ячейки другими ячейками
     * @throws OccupiedWayException    - возникает если фигура не может совершить данное движение
     * @throws FigureNotFoundException - возникает в случае если в заданой ячейки нет фигуры
     */
    public boolean move(Cell source, Cell dest)
            throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = true;
        // 1 метод
        int index = this.findBy(source);

        if (index == -1) {
            result = false;
            throw new FigureNotFoundException("В клетке отсутсвует фигура!");
        }
        // конец 1 метода

        Cell[] steps = figures[index].way(source, dest);
        // 2 метод occupaidWay(way);  проверяет есть ли фигура на пути
        for (Cell cell : steps) {
            index = this.findBy(cell);
            if (index != -1) {
                result = false;
                throw new OccupiedWayException("Ход невозможен. Клетка на пути занята!");
            }
        }
        // конец 2 метода
        figures[index] = figures[index].copy(dest);

        return result;
    }

    /**
     * Прроверяет наличие фигуры в клетке и если фигура массива figures присутсвует в клетке то
     * возвращает индекс этой фигуры в массиве figures.
     *
     * @param cell проверяемая ячейка.
     * @return -1 или соответствующей индекс figures.
     */
    public int findBy(Cell cell) {
        int rst = -1; // ничего не нашел.
        for (int index = 0; index < this.figures.length; index++) {
            if (figures[index] != null && figures[index].position.x == cell.x && figures[index].position.y == cell.y) {
                rst = index;
                break;
            }
        }
        return rst;
    }

}

