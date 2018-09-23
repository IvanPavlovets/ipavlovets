package ru.job4j.gameofchess.figures;

import ru.job4j.gameofchess.Cell;
import ru.job4j.gameofchess.ImposibleMoveException;

/**
 * Абстрактный класс описывает поведение шахматных фигур.
 */
public abstract class Figure {

    /**
     * Кординаты текущей клетки фигуры.
     */
    public final Cell position;

    /**
     * Конструктор по умолчанию который принимает позицию
     * @param position - кординаты фигуры на шахматной доске.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Метод проверяет что данная фигура может так двигаться.
     * Ход фигуры.
     * В классе Logic должны проверить не заняты ли
     * эти клетки другими фигурами, если заняты то запретить двигаться этой клетке
     * @param source - текущая кордината фигуры.
     * @param dest - ячека куда ходит фигура.
     * @return - если фигура можт пойти в этом направлении то вернуть массив ячеек
     * которые должна пройти фигура.
     * @throws ImposibleMoveException - если фигура не может двигаться в этом направлении.
     */
    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    /**
     * Фактическое перемещение фигуры.
     * Создает обьект Figure с кординатой dest. Созданая новая фигура
     * перезаписываеться в массиве
     * @param dest - кординта хода фигуры.
     * @return - соответсвующая шахматная фигура.
     */
    public abstract Figure copy(Cell dest);

}
