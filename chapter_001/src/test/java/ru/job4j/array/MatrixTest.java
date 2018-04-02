package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixTest {

    /**
     * Метод проверяет вывод таблицы умножения на 3.
     */
    @Test
    public void whenDoubleArrHasSize3ThenMultiplicationTableOf3() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiple(3);
        int[][] expect = new int[][]{{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(result, is(expect));
    }

    /**
     * Метод проверяет вывод таблицы умножения на 4.
     */
    @Test
    public void whenDoubleArrHasSize4ThenMultiplicationTableOf4() {
        Matrix matrix = new Matrix();
        int[][] result = matrix.multiple(4);
        int[][] expect = new int[][]{{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        assertThat(result, is(expect));
    }
}
