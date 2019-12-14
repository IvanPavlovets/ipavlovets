package ru.job4j.collectionsPro.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ContainerLinkedList<E> implements Iterable<E>{

    private int size;
    private Node<E> first;
    private int modCount = 0;

    /**
     * Метод вставляет в начало списка данные.
     * @param data
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    /**
     * Метод получения элемента по индексу.
     * В цикле передаеться ссылка на слеющий элемент.
     * @param index
     * @return
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node<E> current = first;
            int expectedModCount = modCount;

            /**
             * существует ли следующая ячейка.
             * @return
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }

            /**
             * Возвращает значение текущей ячейки и переводит
             * корректку текущей позиции вперед.
             * @return - значение текущей ячейки.
             */
            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = current.data;
                current = current.next;
                return element;
            }
        };
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ContainerLinkedList{" +
                "size=" + size +
                ", first=" + first +
                '}';
    }
}
