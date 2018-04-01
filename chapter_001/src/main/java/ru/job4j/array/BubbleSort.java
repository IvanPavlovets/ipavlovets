package ru.job4j.array;

import java.util.Arrays;

public class BubbleSort {

    /**
     * метод осуществляет сортировку пузырьком переданного массива
     *
     * @param array - переданный массив.
     * @return - отсортированный массив.
     */
    public int[] sort(int[] array){
        boolean flag = true;
        // выполняем сортировку до тех пор пока элементы не отсортируються по возростанию.
        while(flag){
            flag = false;
            for (int i = 0; i < array.length - 1 ;i++){
                // если элемент с начала списа больше последующего то делаем перестановку элементов.
                if(array[i] > array[i + 1]){
                    // запоминаем этот больший элемент во временой переменной.
                    int temp = array[i];
                    // на место большего элемента ставим меньший.
                    array[i] = array[i+1];
                    // на место меньшего элемента ставим больший, который запомнили в переменной temp.
                    array[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return array;
    }

}
