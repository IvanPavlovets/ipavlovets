package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = turner.turn(input);
        int[] expect = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }


    /**
     * Метод проверяет массив с нечетным кол-вом элементов.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов,
        // например {1, 2, 3, 4, 5}.
        Turn turner = new Turn();
        int[] input = new int[] {6, 5, 4, 3, 2, 1, 0, 1, 112, 111, 33};
        int[] result = turner.turn(input);
        int[] expect = new int[] {33, 111, 112, 1, 0, 1, 2, 3, 4, 5, 6};
        assertThat(result, is(expect));
    }
}
