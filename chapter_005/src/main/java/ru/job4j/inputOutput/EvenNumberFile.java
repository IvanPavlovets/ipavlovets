package ru.job4j.inputOutput;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("even.txt");
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            Integer number;
            boolean rsl;
            for (String line : lines) {
                number = Integer.parseInt(line);
                rsl = number % 2 == 0;
                System.out.printf("%d - %b%n", number, rsl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
