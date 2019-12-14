package ru.job4j.collectionsPro.list;

public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     * @param data
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Метод удаления первого элемента в списке.
     * @return
     */
    public E delete() {
        E element = first.data;
        Node<E> next = first.next;
        this.first.data = null;
        first = next;
        size--;
        return element;
    }

    /**
     * Метод получения элемента по индексу.
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

    /**
     * Метод получения размера коллекции.
     * @return
     */
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "SimpleArrayList{" +
                "size=" + size +
                ", first=" + first +
                '}';
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
}
