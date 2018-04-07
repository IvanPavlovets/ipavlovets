package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {

    /**
     * Тест проверяет результат метода remove удаляющего ячейки массива
     * с дублирущими значениями.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDublicate arrayDublicate = new ArrayDublicate();
        String[] input = new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = new String[]{"Привет", "Мир", "Супер"};
        String[] result = arrayDublicate.remove(input);
        assertThat(result, is(expect));

    }
}
