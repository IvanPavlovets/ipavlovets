package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {
    /**
     * Тест проверяет рисование квадрата классом Square.
     */
    @Test
    public void whenDrawSquare() {
        Shape square = new Square();
        assertThat(square.draw(), is(new StringBuilder()
                                .append(" +++++\n")
                                .append("+     +\n")
                                .append("+     +\n")
                                .append(" +++++")
                                .toString()
                )
        );
    }
}
