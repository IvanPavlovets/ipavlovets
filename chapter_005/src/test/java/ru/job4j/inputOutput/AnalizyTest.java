package ru.job4j.inputOutput;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void whenPairWithoutComment() {
        List<String> stringReadList = List.of("200 10:56:01",
                                          "500 10:57:01",
                                          "400 10:58:01",
                                          "200 10:59:01",
                                          "500 11:01:02",
                                          "200 11:02:02") ;
        Analizy analizy = new Analizy();
        assertThat(analizy.unavailable(stringReadList),
                is(List.of("10:57:01;10:59:01",
                           "11:01:02;11:02:02"))
        );
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        // заполняем файл содержимым
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:0111:01:02;11:02:02"));
    }
}
