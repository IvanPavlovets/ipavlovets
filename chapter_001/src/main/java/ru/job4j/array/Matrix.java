package ru.job4j.array;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {

    /**
     * Метод выводит двумерный массив(матрицу) в виде таблицы умножения.
     * @param size - кол-во элементов матрицы.
     * @return - таблица умнноджения соответвующего кол-ва элементов.
     */
    public int[][] multiple(int size){
        int[][] data = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                data[i-1][j-1] = j * i;
            }
        }
        return data;
    }

}
