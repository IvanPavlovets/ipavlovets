package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {

    @Test
    public void whenFirstLessSecondThenSecondArg() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstLargerSecondThenFirstArg() {
        Max maxim = new Max();
        int result = maxim.max(5, 1);
        assertThat(result, is(5));
    }

    @Test
    public void whenFirsteQualSecondThenLargerArg() {
        Max maxim = new Max();
        int result = maxim.max(5, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenFirstAndSecondLessThirdArgThenThirdArg() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstLargerSecondAndThirdArgsThenFirstArg() {
        Max maxim = new Max();
        int result = maxim.max(1, 0, -1);
        assertThat(result, is(1));
    }

}
