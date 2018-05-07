package ru.job4j.trackingsystem.start;

import ru.job4j.trackingsystem.io.ConsoleInput;
import ru.job4j.trackingsystem.io.Input;
import ru.job4j.trackingsystem.menu.MenuTracker;
import ru.job4j.trackingsystem.model.Item;
import ru.job4j.trackingsystem.model.Tracker;

/**
 * Класс с системой ввода/вывода для работы с пользовательм.
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * В методе происходи выбор пункта меню пользователем,
     * в зависимсоти от выбронового пун2кта меню выполнение
     * метода идет по соответсвующему направлению ветвления.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        // метод заполняет данные
        menu.fillActions();
        do {
            // каждый раз показываем меню.
            menu.show();
            // спрашиваем пункт меню который хочет выбрать пользователь
            int key = Integer.valueOf(input.ask("Выберете пункт меню"));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        Input console = new ConsoleInput();
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI(console, tracker);
        startUI.init();
    }
}

