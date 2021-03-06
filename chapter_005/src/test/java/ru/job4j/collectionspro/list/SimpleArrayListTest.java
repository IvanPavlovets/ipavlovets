package ru.job4j.collectionspro.list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(3));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(4));
    }

    @Test
    public void whenDeleteElementThenGetThisElementAndOneLessElements() {
        assertThat(list.delete(), is(4));
        assertThat(list.getSize(), is(3));
    }
}
