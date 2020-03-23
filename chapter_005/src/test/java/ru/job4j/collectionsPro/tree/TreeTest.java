package ru.job4j.collectionsPro.tree;

import org.junit.Test;

import java.util.Optional;

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

}
