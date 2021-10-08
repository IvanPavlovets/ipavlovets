package ru.job4j.inoutput;

import java.io.FileInputStream;

public class ReadFile {
    /**
     * split(System.lineSeparator() - разбиваем на строки и кладем в массив
     * @param args
     */
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
