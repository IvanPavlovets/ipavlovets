package ru.job4j.array;

import java.util.Arrays;

public class BubbleSort {

    /**
     * метод осуществляет сортировку пузырьком переданного массива.
     * Выполняем сортировку до тех пор пока элементы не отсортируються по возростанию.
     * Если элемент с начала списа больше последующего то делаем перестановку элементов.
     * Запоминаем этот больший элемент во временой переменной, а на место большего
     * элемента ставим меньший.
     *
     * @param array - переданный массив.
     * @return - отсортированный массив.
     */
    public int[] sort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return array;
    }

}
