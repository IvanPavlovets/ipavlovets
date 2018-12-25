package ru.job4j.collections.convert;

import java.util.List;

public class ConvertList2Array {

    /**
     * Метод равномерно разбивает коллекцию list на количество строк двумерного массива.
     * В методе организуеться проверка - если количество элементов не кратно количеству строк
     * (результат в переменной tail),
     * то оставшееся количество в массиве заполняеться нулями
     * (заполняем коллекцию на недостающее кол-во).
     * @param list
     * @return
     */
    public int[][] toArray (List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int out = 0;
        int i = 0;
        for (int[] arr : array) {
            int in = 0;
            for (int q : arr) {
                array[out][in++] = list.get(i++);
                if (i == list.size()){
                    break;
                }
            }
            out++;
        }
        return array;
    }

}
