package ru.job4j.task;

import org.junit.Test;
import ru.job4j.stream.StreamConverter;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamApiTest {
    @Test
    public void whenMakeEvenNumbersThenDoIt() {
        StreamApi api = new StreamApi();
        int[] array1 = {1, 2, 3, 4, 8, 7, 9};
        int[] result = api.makeEvenNumbers(array1);
        int[] expected = {2, 4, 8};
        assertThat(result, is(expected));
    }

    @Test
    public void whenMakeSquareEvenNumbersThenDoIt() {
        StreamApi api = new StreamApi();
        int[] array1 = {1, 2, 3, 4};
        int[] result = api.mekeSquareEvenNumbers(array1);
        int[] expected = {4, 16};
        assertThat(result, is(expected));
    }

    @Test
    public void whenUseStreamModifyThenDoIt() {
        StreamApi api = new StreamApi();
        int[] array1 = {1, 2, 3, 4};
        int result = api.streamModify(array1);
        int expected = 20;
        assertThat(result, is(expected));
    }

}
