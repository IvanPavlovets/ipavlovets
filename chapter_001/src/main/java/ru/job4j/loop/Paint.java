package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Класс рисует различные варинта треугольников в псевдографике.
 *
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Уневирсальный метод пострения треуголников, в зависимости от
     * принимаемых параметров и условий проверки логических вырожений
     * Обьект StringBuilder screen - буфер для результата.
     * Внешний цикл двигается по строкам.
     * Внутренний цикл определяет положение ячейки в строке.
     * В условие определяеться простановка символа ^ или пробела.
     *
     * @param height - высота треугольника.
     * @param weight - шерина треугольника.
     * @param predict - условие логического выражения.
     * @return - треугольник из символов ^ и пробелов.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

}
