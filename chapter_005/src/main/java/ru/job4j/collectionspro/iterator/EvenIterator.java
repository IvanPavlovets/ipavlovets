package ru.job4j.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private int[] values;
    private int position = 0;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean q = false;
        for (int i = position; values.length > i; i++) {
            if (values[i] % 2 == 0) {
                position = i;
                q = true;
                break;
            }
        }
        return q;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[position++];
    }
}

