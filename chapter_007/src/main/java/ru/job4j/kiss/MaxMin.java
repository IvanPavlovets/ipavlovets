package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс для поиска максимального и минимального элемента по критерию
 */
public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return select(value, comparator, a -> a > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return select(value, comparator, a -> a < 0);
    }

    /**
     * Выбирает значение по критерию (min or max) из List
     * @param value
     * @param comparator
     * @param predicate
     * @param <T>
     * @return
     */
    public <T> T select(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rst = value.get(0);
        T val;
        for (int i = 1; i < value.size(); i++) {
            val = value.get(i);
            if (predicate.test(comparator.compare(val, rst))) {
                rst = val;
            }
        }
        return rst;
    }
}
