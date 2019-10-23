package ru.job4j.collectionsPro.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    @Test
    public void whenInvokeAddThenAddElement () {
        SimpleArray arr1 = new SimpleArray(2);
        arr1.add(1);
        int expected = 1;
        int result = (Integer) arr1.getArrayData()[0];
        assertThat(result, is(expected));
    }

    @Test
    public void whenInvokeSetThenSetElement () {
        SimpleArray arr1 = new SimpleArray(2);
        arr1.add(1);
        arr1.add(1);
        arr1.set(1, "test");
        String expected = "test";
        String result = (String) arr1.getArrayData()[1];
        assertThat(result, is(expected));
    }

    @Test
    public void whenInvokeRemoveThenRemoveElement () {
        SimpleArray arr1 = new SimpleArray(2);
        arr1.add(1);
        arr1.add(2);
        arr1.remove(1);
        int[] expected = {1};
        assertThat(arr1.getArrayData(), is(expected));
    }

    @Test
    public void whenInvokeGetThenGetElement () {
        SimpleArray arr1 = new SimpleArray(2);
        arr1.add(1);
        arr1.add(2);
        int result = (Integer) arr1.get(1);
        int expected = 2;
        assertThat(result, is(expected));
    }
}
