package ru.job4j.inoutput;

import java.io.Console;


public class Main1 {

    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        Console console = System.console();
        if (console != null) {

            String login = console.readLine("Введите логин:");
            char[] password = console.readPassword("Введите пароль:");

            console.printf("Введенный логин: %s \n", login);
            console.printf("Введенный пароль: %s \n", new String(password));
        }
    }
}
