package ru.job4j.trackingsystem.menu;

import ru.job4j.trackingsystem.model.Tracker;
import ru.job4j.trackingsystem.io.Input;

/**
 * Интерфейс всех действий меню трекера.
 */
public interface UserAction {
    /**
     * Метод возвращает ключ для действия пользователя
     * которе он хочет выполнить.
     * @return - ключ обозначающий действие из пункта меню.
     */
    int key();

    /**
     * Метод исполняет основные действия меню трекера.
     * @param input - обьект интерфейса ввода.
     * @param tracker - базовый класс хранилища и всех утилитных методов трекинговой системы.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Сообщает пользователю что выбраное действие делает.
     * @return - строка с описанием.
     */
    String info();
}
