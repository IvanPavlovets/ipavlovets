package ru.job4j.inoutput;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {

    /**
     * Получение данных от пользователя.
     */
    private String input;

    /**
     * Класс Scanner принимает поток ввода (System.in) с консоли,
     * с помощью метода получения полной строки nextLine.
     */
    private Scanner scanner = new Scanner(System.in);

    public void talk() {
        try (BufferedReader in = new BufferedReader(new FileReader("randomphraser.txt"));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("randomphraser1.txt")))) {

            input = scanner.nextLine(); // чтение с консоли
            while (!input.contains("стоп")) {
                System.out.println(in.readLine());
                //out.print(input); // запись в файл
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String generateRandomWord(int wordLength) {
        Random r = new Random(); // Intialize a Random Number Generator with SysTime as the seed
        StringBuilder sb = new StringBuilder(wordLength);
        for (int i = 0; i < wordLength; i++) { // For each letter in the word
            char tmp = (char) ('a' + r.nextInt('z' - 'a')); // Generate a letter between a and z
            sb.append(tmp); // Add it to the String
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        new ConsoleChat().talk();

        try (BufferedReader in = new BufferedReader(new FileReader("randomphraser.txt"));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("randomphraser1.txt")))) {

            Random r = new Random();
            String s;
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine(); // чтение с консоли
            do {

                s = String.valueOf(in.lines().filter(s1 -> Boolean.parseBoolean(s1.indent(r.nextInt()))));
                System.out.println(s); // читать из файла
                System.out.println(input); // то что ввел в консоли
                out.print(input); // запись в файл то что ввел в консоли
                input = scanner.nextLine(); // чтение с консоли
            } while (!"stop".equals(input));


        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println(new ConsoleChat().generateRandomWord(5));

    }
}
