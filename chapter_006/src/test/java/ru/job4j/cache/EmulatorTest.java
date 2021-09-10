package ru.job4j.cache;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmulatorTest {
    /**
     * Тестирование пустого кеша, и кеша в котором уже есть файл.
     *
     * @throws IOException
     */
    @Test
    public void testCache() throws IOException {
        Path tempFile1 = Files.createTempFile("Names", ".txt");
        Files.write(tempFile1, "Ivan, Petr, Rail\n".getBytes());

        Emulator emulator = new Emulator(tempFile1.getParent().toString());
        String result = emulator.getFileContent(tempFile1.getFileName().toString());
        Assert.assertThat(result, Is.is("Ivan, Petr, Rail\n"));

        result = null;
        Assert.assertThat(emulator.getFileContent(tempFile1.getFileName().toString()),
                Is.is("Ivan, Petr, Rail\n"));

    }
}
