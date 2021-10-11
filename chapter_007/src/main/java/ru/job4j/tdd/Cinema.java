package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {
    /**
     * Поиск сенса по условию.
     * @param filter
     * @return список сеансов.
     */
    List<Session> find(Predicate<Session> filter);

    /**
     * Покупка билета.
     * @param account
     * @param row
     * @param column
     * @param date
     * @return
     */
    Ticket buy(Account account, int row, int column, Calendar date);

    /**
     * добавить сеанс в хранилище.
     * @param session
     */
    void add(Session session);
}
