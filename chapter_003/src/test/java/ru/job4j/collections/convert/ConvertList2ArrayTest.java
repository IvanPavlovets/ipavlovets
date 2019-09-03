package ru.job4j.collections.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array convertList2Array = new ConvertList2Array();

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);

        int[][] result = convertList2Array.toArray(list, 3);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};

        assertThat(result, is(expect));
    }
}
