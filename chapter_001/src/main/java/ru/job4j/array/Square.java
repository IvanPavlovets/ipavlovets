package ru.job4j.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * Метод возвращает массив целых чисел,
     * каждое из которых возведено в квадрат.
     *
     * @param bound - размер массива.
     * @return - массив целых чисел.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i-1] = (int) Math.pow(i,2);
        }
        return rst;
    }

}
