package ru.job4j.inoutput;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

public class AbuseTest {
    /**
     * создает файл во временой дериктории.
     */
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /**
     * out.println("hello foolish dude ") - заполняем файл содержимым
     * in.lines().forEach(rsl::append) - записываем файл полученый результат
     *
     * @throws IOException
     */
    @Test
    public void drop() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hello foolish dude ");
        }
        Abuse.drop(source.getAbsolutePath(), target.getAbsolutePath(), List.of("foolish"));
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("hello dude "));
    }
}

