package ru.job4j.collectionsPro.generic;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    Object[] arrayData;
    int position = 0;

    public SimpleArray(int lenght) {
        this.arrayData = new Object[lenght];
    }

    /**
     * Добовляет указанный элемент model в первую свободную ячейку.
     * @param model
     */
    public void add(T model) {
        arrayData[this.position++] = model;
    }

    /**
     * Заменяет указанным элементом model элемент, находящийся по индексу index.
     * @param index
     * @param model
     */
    public void set(int index, T model) {
        arrayData[index] = model;
    }

    /**
     * Удаляет элемент по указанному индексу, все находящиеся справа элементы при этом
     * сдвигаються на единицу влево.
     * @param index
     */
    public void remove(int index) {
        if (0 > index || index >= arrayData.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс вне диапозона массива!");
        }
        Object[] arrayData1 = new Object[arrayData.length - 1];
        System.arraycopy(arrayData, 0, arrayData1, 0, index);
        System.arraycopy(arrayData, index + 1, arrayData1, index, arrayData.length - index - 1);
        arrayData = arrayData1;
    }

    /**
     * Возвращает элемент, расположенный по указанному индексу;
     * @param index
     * @return
     */
    public T get(int index) {
        return (T) arrayData[index];
    }

    @Override
    public String toString() {
        return "SimpleArray{" +
                "arrayData=" + Arrays.toString(arrayData) +
                ", position=" + position +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return arrayData.length > i;
            }

            @Override
            public T next() {
                return (T) arrayData[i++];
            }
        };
    }

    public static void main(String[] args) {
        SimpleArray simpleArray = new SimpleArray(6);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.add(6);

        System.out.println(simpleArray);

        simpleArray.remove(5);

        System.out.println(simpleArray);

        System.out.println(simpleArray.get(4));
        System.out.println(simpleArray);

        Iterator it = simpleArray.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
