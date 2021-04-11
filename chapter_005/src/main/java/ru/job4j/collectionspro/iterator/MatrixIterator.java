package ru.job4j.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {
    private int[][] values;
    private int i, j;

    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return (i < values.length && j < values[i].length);
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int element = values[i][j];
        j++;
        while (i < values.length && j >= values[i].length) {
            j = 0;
            i++;
        }
        return element;
    }
}
