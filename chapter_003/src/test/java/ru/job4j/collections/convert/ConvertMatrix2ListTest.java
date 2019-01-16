package ru.job4j.collections.convert;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    /**
     * Тест проверяет конвертацию списка массивов целых чисел в
     * список целых чисел.
     */
    @Test
    public void whenInputListOfIntArrayThenListOfInteger() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        List<int[]> input = Arrays.asList(new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6, 7});

        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        List<Integer> result = list.convert(input);
        assertThat(result, is(expect));
    }
}