package ru.job4j.collectionsPro.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ContainerListTest {
    private ContainerList<Integer> list;

    @Before
    public void beforeTest() {
        list = new ContainerList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
    }

    @Test
    public void whenAddEightElementsAndCallGetThenDoIt() {
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
        assertThat(list.get(3), is(4));
        assertThat(list.get(4), is(5));
        assertThat(list.get(5), is(6));
        assertThat(list.get(6), is(7));
        assertThat(list.get(7), is(8));
        assertThat(list.get(8), is(9));
        assertThat(list.get(9), is(10));
        assertThat(list.get(10), is(11));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementWhileIteratorCallNextThenCallException() {
        Iterator<Integer> listIt = list.iterator();
        listIt.next();
        list.add(12);
        listIt.next();
    }


}
