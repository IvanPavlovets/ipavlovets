package ru.job4j.collectionsPro.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private int[] values1;
    private int position = 0;

    public EvenIterator(int[] values) {
        this.values1 = Arrays.stream(values).filter(value -> value % 2 == 0).toArray();
    }

    @Override
    public boolean hasNext() {
        return values1.length > position;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values1[position++];
    }
}

