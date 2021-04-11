package ru.job4j.collectionspro.set;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    private SimpleSet<Integer> set;

    @Before
    public void beforeTest() {
        set = new SimpleSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(4);
        set.add(5);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        set.add(11);
    }

    @Test
    public void whenAddEightElementsAndCallGetThenDoItWithNoDublicats() {
        assertThat(set.get(0), is(1));
        assertThat(set.get(1), is(2));
        assertThat(set.get(2), is(3));
        assertThat(set.get(3), is(4));
        assertThat(set.get(4), is(5));
        assertThat(set.get(5), is(6));
        assertThat(set.get(6), is(7));
        assertThat(set.get(7), is(8));
        assertThat(set.get(8), is(9));
        assertThat(set.get(9), is(10));
        assertThat(set.get(10), is(11));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementWhileIteratorCallNextThenCallException() {
        Iterator<Integer> listIt = set.iterator();
        listIt.next();
        set.add(12);
        listIt.next();
    }
}
