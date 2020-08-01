package ru.job4j.inputOutput;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.inputOutput.Search.search;

public class Zip {

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) { // поток записи zip архива
            zip.putNextEntry(new ZipEntry(source.getPath())); // добавление обьекта ZipEntry (оболочка source) в поток записи
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes()); // записывается содержимое файлов (байты в файл zip)
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        new Zip().packSingleFile(
//                new File("./chapter_005/pom.xml"),
//                new File("./chapter_005/pom.zip"));

        Path start = Paths.get(".");

        List<File> src = search(start, "java").stream().map(Path::toFile).collect(Collectors.toList());

        new Zip().packFiles(src,
                new File("./chapter_005/java.zip"));
    }
}
