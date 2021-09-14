package ru.job4j.cache;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCacheTest {

    @Test
    public void whenCacheNullThenLoad() throws IOException {
        Path tempFile1 = Files.createTempFile("Names", ".txt");
        Files.write(tempFile1, "Ivan, Petr, Rail\n".getBytes());

        DirFileCache dirFileCache = new DirFileCache(tempFile1.getParent().toString());

        String result = dirFileCache.get(tempFile1.getFileName().toString());
        Assert.assertThat(result, Is.is("Ivan, Petr, Rail\n"));

        result = null;
        Assert.assertThat(dirFileCache.get(tempFile1.getFileName().toString()),
                Is.is("Ivan, Petr, Rail\n"));
    }
}
