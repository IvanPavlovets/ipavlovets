package ru.job4j.collections.convert;

import java.util.Arrays;
import java.util.List;

public class ConvertList2Array {

    /**
     * Метод равномерно разбивает коллекцию list на количество строк двумерного массива.
     * В методе организуеться проверка - если количество элементов не кратно количеству строк
     * (результат в переменной tail),
     * то оставшееся количество в массиве заполняеться нулями
     * (заполняем коллекцию на недостающее кол-во).
     *
     * @param list
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int out = 0;
        int in = 0;
        for (Integer integer : list) {
            array[out][in++] = integer;
            if (in == cells) {
                out++;
                in = 0;
            }
        }
        return array;
    }
}
