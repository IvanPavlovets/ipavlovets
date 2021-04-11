package ru.job4j.collectionspro.list;

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

    @Test
    public void whenHasCycleThenGetTrue() {
        ContainerLinkedList.Node first = new ContainerLinkedList.Node(1);
        ContainerLinkedList.Node two = new ContainerLinkedList.Node(2);
        ContainerLinkedList.Node third = new ContainerLinkedList.Node(3);
        ContainerLinkedList.Node four = new ContainerLinkedList.Node(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(list.hasCycle(first), is(true));
        assertThat(list.hasCycle(two), is(true));
        assertThat(list.hasCycle(third), is(true));
        assertThat(list.hasCycle(four), is(true));
    }

    @Test
    public void whenNoCycleThenGetFalse() {
        ContainerLinkedList.Node five = new ContainerLinkedList.Node(5);
        ContainerLinkedList.Node six = new ContainerLinkedList.Node(6);
        assertThat(list.hasCycle(five), is(false));
        assertThat(list.hasCycle(six), is(false));
    }


}
