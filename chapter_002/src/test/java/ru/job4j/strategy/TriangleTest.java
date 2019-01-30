package ru.job4j.strategy;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    /**
     * Тест проверяет рисование треугольника классом Triangle.
     */
    @Test
    public void whenDrawTriangle() {
        Shape triangle = new Triangle();
        StringJoiner pic = (new StringJoiner(
                System.lineSeparator(), "", System.lineSeparator()));
        pic.add("   ^   ");
        pic.add("  ^ ^  ");
        pic.add(" ^   ^ ");
        pic.add("^^^^^^^");
        assertThat(triangle.draw(), is(pic.toString()));
    }

}
