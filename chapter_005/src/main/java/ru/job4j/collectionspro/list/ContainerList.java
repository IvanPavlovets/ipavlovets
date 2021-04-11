package ru.job4j.collectionspro.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ContainerList<E> implements Iterable<E> {
    private Object[] container;
    private int position = 0;
    private static final int DEFAULTCAPACITY = 10;
    private int modCount = 0;


    public ContainerList() {
        this.container = new Object[DEFAULTCAPACITY];
    }

    /**
     * Добовляет указанный элемент в первую свободную ячейку.
     * @param value
     */
    public void add(E value) {
        modCount++;
        if (position == container.length) {
            container = Arrays.copyOf(container, position + 10);
        }
        container[this.position++] = value;
    }

    /**
     * Возвращает элемент, расположенный по указанному индексу;
     * @param index
     * @return
     */
    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0;
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return container.length > i;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[i++];
            }
        };
    }

    @Override
    public String toString() {
        return "ContainerList{"
                +
                "container=" + Arrays.toString(container)
                +
                ", position=" + position + '}';
    }

}

