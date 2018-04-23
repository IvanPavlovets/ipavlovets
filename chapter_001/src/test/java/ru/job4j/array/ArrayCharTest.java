package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayCharTest {

    /**
     * Тест проверяет метод если тот возвращает true.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    /**
     * Метод проверяет метод если тот возвращает false.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }

    /**
     * Метод возвращает true если слово содержит другое слово.
     */
    @Test
    public void whenOriginWordContainsSubWordThenTrue() {
        ArrayChar word = new ArrayChar("игротека");
        boolean result = word.contains("игротека", "грот");
        assertThat(result, is(true));
    }

    /**
     * Метод возвращает false если слово не содержит другое слово.
     */
    @Test
    public void whenOriginWordNotContainsSubWordThenFalse() {
        ArrayChar word = new ArrayChar("игротека");
        boolean result = word.contains("игротека", "гор");
        assertThat(result, is(false));
    }
}
