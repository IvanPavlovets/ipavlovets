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
     * out.print(input) - запись в файл
     */
    private Scanner scanner = new Scanner(System.in);

    public void talk() {
        try (BufferedReader in = new BufferedReader(new FileReader("randomphraser.txt"));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("randomphraser1.txt")))) {

            input = scanner.nextLine();
            while (!input.contains("стоп")) {
                System.out.println(in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method generate a letter between a and z
     * Random - Intialize a Random Number Generator with SysTime as the seed
     * In the cycle - for each letter in the word
     * append - Add it to the String
     * @param wordLength
     * @return
     */
    public String generateRandomWord(int wordLength) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(wordLength);
        for (int i = 0; i < wordLength; i++) {
            char tmp = (char) ('a' + r.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        return sb.toString();
    }


    /**
     *   input = scanner.nextLine(); - чтение с консоли
     *   System.out.println(new ConsoleChat().generateRandomWord(5));
     * @param args
     */
    public static void main(String[] args) {
        new ConsoleChat().talk();

        try (BufferedReader in = new BufferedReader(new FileReader("randomphraser.txt"));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("randomphraser1.txt")))) {

            Random r = new Random();
            String s;
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            do {
                s = String.valueOf(in.lines().filter(s1 -> Boolean.parseBoolean(s1.indent(r.nextInt()))));
                System.out.println(s);
                System.out.println(input);
                out.print(input);
                input = scanner.nextLine();
            } while (!"stop".equals(input));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
