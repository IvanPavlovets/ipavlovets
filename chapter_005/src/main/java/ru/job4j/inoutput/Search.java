package ru.job4j.inoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
    //    search(start, "java").forEach(System.out::println);
    }

    public List<Path> search(Path root, String ext) throws IOException {
        SearchFiles seacher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, seacher);
        return seacher.getPaths();
    }
}
