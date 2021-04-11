package ru.job4j.collectionspro.list;

import java.util.NoSuchElementException;

/**
 * Очередь на двух стеках.
 * @param <T>
 */
public class SimpleQueue<T> {

    SimpleStack<T> store1;
    SimpleStack<T> store2;

    public SimpleQueue() {
        this.store1 = new SimpleStack<>();
        this.store2 = new SimpleStack<>();
    }

    /**
     * Возвращает значение и удалять его из коллекции.
     * @return
     */
    public T poll() {
        if (store2.getSize() == 0) {
            if (store1.getSize() == 0) {
                throw new NoSuchElementException();
            }
            while (store1.getSize() != 0) {
                store2.push(store1.poll());
            }
        }
        return store2.poll();
    }

    /**
     * Помещает значение в коллекцию.
     * @param value
     */
    public void push(T value) {
        store1.push(value);
    }

    public static void main(String[] args) {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
