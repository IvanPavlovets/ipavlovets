package ru.job4j.collectionspro.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenAddDublicatThenAddUnicumElement() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        tree.add(5, 6);
        tree.add(5, 6);
        Tree<Integer> tree1 = new Tree<>(5);
        tree1.add(5, 6);
        assertThat(tree.findBy(5).get().children, is(tree1.root.children));
    }

    @Test
    public void whenAdd3ChildrenThenReturnFalse() {
        Tree<Integer> tree = new Tree<>(2);
        tree.add(2, 1);
        tree.add(2, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        tree.add(5, 6);
        tree.add(5, 7);
        tree.add(5, 8);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenAdd2ChildrenThenReturnTrue() {
        Tree<Integer> tree = new Tree<>(2);
        tree.add(2, 1);
        tree.add(2, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        tree.add(5, 6);
        tree.add(5, 7);
        assertThat(tree.isBinary(), is(true));
    }

}
