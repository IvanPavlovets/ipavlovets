package ru.job4j.trackingsystem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.trackingsystem.io.StubInput;
import ru.job4j.trackingsystem.io.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(Arrays.asList("invalid", "1")));
        input.ask("Enter", Arrays.asList((Integer) 1));
        assertThat(this.mem.toString(), is(String.format("Пожайлуста введите корректные даные еще раз.%n"))
        );
    }
}