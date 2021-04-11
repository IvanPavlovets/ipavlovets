package ru.job4j.collectionspro.set;

import ru.job4j.collectionspro.list.ContainerList;

import java.util.Iterator;

/**
 * Пример реализации контейнера Set, являеться оберткой над ContainerList,
 * последний включен посредством копазиции и реализован с помощью массива.
 * @param <E>
 */
public class SimpleSet<E> implements Iterable<E> {
    private ContainerList container;

    public SimpleSet() {
        this.container = new ContainerList();
    }

    /**
     * Добовляет указанный элемент в первую свободную ячейку.
     * Исключение дубликатов происходит с помощь прерывания цикла
     * и выхода из метода посредством оператара - return.
     * @param value
     */
    public void add(E value) {
        Iterator<E> it = container.iterator();
        while (it.hasNext()) {
            if (value.equals(it.next())) {
                return;
            }
        }
        container.add(value);
    }

    /**
     * Возвращает элемент, расположенный по указанному индексу.
     * В настоящей коллекции Set - нет такого метода.
     * @param index
     * @return
     */
    public E get(int index) {
        return (E) container.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return container.iterator();
    }

    @Override
    public String toString() {
        return "SimpleSet{"
                +
                "container=" + container + '}';
    }
}

