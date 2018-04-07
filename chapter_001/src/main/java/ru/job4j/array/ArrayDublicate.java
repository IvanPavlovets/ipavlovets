package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс для работы с массивами.
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDublicate {

    /**
     * Метиод убирает все дубликаты строк из массива
     * @param array - входящий массив строк.
     * @return - массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int unique  = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }

}
