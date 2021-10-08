package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    /**
     * поле содержит дефолтный вывод в консоль.
      */
    private final PrintStream stdout = System.out;
    /**
     * буфер для результата.
      */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Метод устанавлевает поток вывода до начала теста.
     */
    @Before
    public void loadOutput() {
        System.out.println("Выполнить до начала метода");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Метод устанавлевает стандартный поток вывода после теста.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("Выполнить после выполнения метода");
    }


    /**
     * Тест проверяет работу класса Paint и его единственного метода draw выводящего информацию в консоль.
     * Для нужд тестирования мы заменяем поток вывода в консоль на вывод в память - ByteArrayOutputStream.
     * draw(new Square()) - выполняем действия пишушиее в консоль.
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                        .append(" +++++\n")
                        .append("+     +\n")
                        .append("+     +\n")
                        .append(" +++++")
                        .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        StringJoiner pic = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        pic.add("   ^   ");
        pic.add("  ^ ^  ");
        pic.add(" ^   ^ ");
        pic.add("^^^^^^^");
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(pic.toString()));
    }
}
