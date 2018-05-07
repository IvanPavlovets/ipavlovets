package ru.job4j.trackingsystem.io;

import ru.job4j.trackingsystem.io.Input;

import java.util.Scanner;

/**
 * Класс для работы с пользователем, реализует интерфейс Input.
 */
public class ConsoleInput implements Input {
    /**
     * Класс Scanner принимает поток ввода (System.in) с консоли,
     * с помощью метода получения полной строки nextLine.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * метод печатает вопрос а потом получает данные
     * из консоли введеные пользователем.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
