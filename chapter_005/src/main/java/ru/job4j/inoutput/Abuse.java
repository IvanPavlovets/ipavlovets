package ru.job4j.inoutput;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class Abuse {
    /**
     * Коректирует входяший файл, результат в исходящем файле.
     * @param source - исходный файл.
     * @param target - откоректированый файл.
     * @param words - список слов которые необходимо вырезать.
     * @throws IOException
     */
    public static void drop(String source, String target, List<String> words) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !words.contains(word)).map(word -> word + " ")
                    .forEach(out::print);
        }
    }
}
