package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamConverterTest {
    @Test
    public void whenConvertMatrixListThenGetList() {
        StreamConverter converter = new StreamConverter();
        List<List<Integer>> matrix = Arrays.asList(Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
        List<Integer> result = converter.matrixListToList(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(result, is(expected));
    }

    @Test
    public void whenConvertMatrixArrayThenGetList() {
        StreamConverter converter = new StreamConverter();
        Integer[][] matrix = {{5, 6}, {7, 8}};
        List<Integer> result = converter.matrixArrayToList(matrix);
        List<Integer> expected = Arrays.asList(5, 6, 7, 8);
        assertThat(result, is(expected));
    }
}
