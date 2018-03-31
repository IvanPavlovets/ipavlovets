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
     *
     * @param height - высота треугольника.
     * @param weight - шерина треугольника.
     * @param predict - условие логического выражения.
     * @return - треугольник из символов ^ и пробелов.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        // Буфер для результата.
        StringBuilder screen = new StringBuilder();
        // внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
                // условие простановки символа ^ или пробела.
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
