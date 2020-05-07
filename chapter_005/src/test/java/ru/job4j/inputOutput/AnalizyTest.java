package ru.job4j.inputOutput;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void whenPairWithoutComment() {
        List<String> stringReadList = List.of("200 10:56:01",
                                          " ",
                                          "500 10:57:01",
                                          " ",
                                          "400 10:58:01",
                                          " ",
                                          "200 10:59:01",
                                          " ",
                                          "500 11:01:02",
                                          " ",
                                          "200 11:02:02") ;
        Analizy analizy = new Analizy();
        assertThat(analizy.unavailable(stringReadList),
                is(List.of("10:57:01;10:59:01",
                           "11:01:02;11:02:02"))
        );
    }
}
