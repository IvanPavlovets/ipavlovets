package ru.job4j.collectionspro.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> iterator = (new ArrayList<Integer>()).iterator();

            /**
             * метод смотрит есть следующий элемнт в структуре данных
             * @return
             */
            @Override
            public boolean hasNext() {
                while (it.hasNext() && !iterator.hasNext()) {
                    iterator = it.next();
                }
                return iterator.hasNext();
            }

            /**
             * Метод должен вернуть элемент и сдвинуть каретку
             * @return
             */
            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        };
    }
}