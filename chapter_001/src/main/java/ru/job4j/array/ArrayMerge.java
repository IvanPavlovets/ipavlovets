package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayMerge {

    private int[] arr1;
    private int[] arr2;

    // Инициализация в конструкторе.
    public ArrayMerge(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    /**
     * Сортировка слиянием 2х отсортированых массивов - во временом буффере,
     * по порядку сравниваем между собой по 1 элементу из каждого массива,
     * меньший отправляем в результирующий массив. Каждый раз добавляем в буфер число
     * из того массива элемент которого, при прошлом сравнении в буфере, ушел
     * в результирующий массив. Когда в какомнибудь из массивов кончаться элементы,
     * то в резултирующий массив перемешаем оставшееся элемент из временного буфера
     * а также оставшися элементы из незаконченого массива.
     *
     * @param inputArr1 - осортированый массив 1.
     * @param inputArr2 - осортированый массив 2
     * @return - отсортированый массив 3 с длинной двух входящих массивов.
     */
    public int[] merge(int[] inputArr1, int[] inputArr2) {
        // резултирующий массив.
        int[] arr3 = new int[inputArr1.length + inputArr2.length];

        // индиксы для массивов arr1 и arr2.
        int arr1Pointer = 0, arr2Pointer = 0;

        for (int i = 0; i < arr3.length; i++) {
            // проверяем не привысил ли индекс приделы массива arr1.
            if (arr1Pointer > arr1.length - 1) {
                int a = arr2[arr2Pointer];
                arr3[i] = a;
                arr2Pointer++;
                // проверяем не привысил ли индекс приделы массива arr2.
            } else if (arr2Pointer > arr2.length - 1) {
                int a = arr1[arr1Pointer];
                arr3[i] = a;
                arr1Pointer++;
                // перемещение наименьшего элемента из массива arr1.
            } else if (arr1[arr1Pointer] < arr2[arr2Pointer]) {
                int a = arr1[arr1Pointer];
                arr3[i] = a; // кладем в результирующий массив элемент из arr1.
                arr1Pointer++; // передвигаем указатель массива arr1.
                // иначе перемещение наименьшего элемента из массива arr2.
            } else {
                int b = arr2[arr2Pointer];
                arr3[i] = b; // кладем в результирующий массив элемент из arr2.
                arr2Pointer++; // передвигаем указатель массива arr1.
            }
        }
        return arr3;
    }

}

