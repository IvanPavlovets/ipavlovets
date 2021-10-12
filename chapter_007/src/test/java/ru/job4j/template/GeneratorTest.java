package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GeneratorTest {

    @Ignore
    @Test
    public void whenProduceThenReturnString() {
        String template1 = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> testArgs1 = Map
                .of("${name}", "Petr Arsentev",
                        "${subject}", "you");
        Generator gen = new StringGenerator();
        String result = gen.produce(template1, testArgs1);
        assertEquals("I am a Petr Arsentev, Who are you? ", result);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenGetExtraKeysThenGetException() {
        String template2 = "I am a ${name}?";
        Map<String, String> testArgs2 = Map
                .of("${name}", "Petr Arsentev",
                        "${subject}", "you");
        Generator gen = new StringGenerator();
        gen.produce(template2, testArgs2);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughKeysThenGetException() {
        String template3 = "I am a ${name}, Who are ${subject}? What are doing on ${day}";
        Map<String, String> testArgs2 = Map
                .of("${name}", "Petr Arsentev",
                        "${subject}", "you");
        Generator gen = new StringGenerator();
        gen.produce(template3, testArgs2);
    }
}
