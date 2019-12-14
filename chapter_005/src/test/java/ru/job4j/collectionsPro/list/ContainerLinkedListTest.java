package ru.job4j.collectionsPro.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ContainerLinkedListTest {
    private ContainerLinkedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new ContainerLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddEightElementsAndCallGetThenDoIt() {
        assertThat(list.get(0), is(3));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(1));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementWhileIteratorCallNextThenCallException() {
        Iterator<Integer> it = list.iterator();
        it.next();
        list.add(4);
        it.next();
    }
}
