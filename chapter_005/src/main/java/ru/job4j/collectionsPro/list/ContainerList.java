package ru.job4j.collectionsPro.list;

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
        return "ContainerList{" +
                "container=" + Arrays.toString(container) +
                ", position=" + position +
                '}';
    }

    public static void main(String[] args) {
        ContainerList<Integer> list = new ContainerList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        System.out.println(list);
        System.out.println(list.get(2));
    }

}

