package ru.job4j.collections.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array convertList2Array = new ConvertList2Array();

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        int[][] result = convertList2Array.toArray(list, 3);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 0 ,0}};

        assertThat(result, is(expect));
    }
}
