package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ArrayMergeTest {

    /**
     * Метод проверяет слияние 2-х остортированых массивов в третий.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        int[] inputArr1 = new int[] {21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
        int[] inputArr2 = new int[] {10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};

        ArrayMerge arrayMerge = new ArrayMerge(inputArr1, inputArr2);
        int[] resultArr3 = arrayMerge.merge(inputArr1, inputArr2);
        int[] expect = new int[] {10, 11, 21, 23, 24, 40, 41, 50, 65, 75, 76, 78, 77, 86, 98, 101, 190, 900,
                1100, 1200, 2100, 2200, 2300, 2400, 2500, 3000, 5000};
        assertThat(resultArr3, is(expect));
    }
}
