package ru.job4j.trackingsystem.io;

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

    /**
     * В перегруженом методе происходит преобразование возвращеного значения,
     * с типом String из метода ask в тип int. Затем происходит сравнение
     * этого значения с допустимым диапозоном значений ключа.
     * @param question - вопрос системы ввода/вывода.
     * @param range - диапозон, входит ли значение в данный ключ.
     * @return
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        // проверяем что данный ключ содержиться в диапозоне
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        // в условии следим что значения key входят в диапозон range
        if (exist){
            return key;
        } else {
            throw new MenuOutException("Вышли из диапозона меню");
        }
    }

}
