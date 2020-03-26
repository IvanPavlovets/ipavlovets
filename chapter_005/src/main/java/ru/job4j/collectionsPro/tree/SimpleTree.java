package ru.job4j.collectionsPro.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface SimpleTree<E> {
    boolean add(E parent, E child);

    boolean isBinary();

    Optional<Node<E>> findBy(E value);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }



        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", children=" + children +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?> node = (Node<?>) o;
            return value.equals(node.value) &&
                    children.equals(node.children);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, children);
        }
    }
}
