package ru.job4j.trackingsystem.menu;

import org.junit.Test;
import ru.job4j.trackingsystem.io.ConsoleInput;
import ru.job4j.trackingsystem.model.Item;
import ru.job4j.trackingsystem.model.MemTracker;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Тесты с использованием библиотеки mackito
 */
public class MenuTrackerTest {
    /**
     * Тест с применением mock-обьекта (обьект заглушка)
     * Проверяем действие - изменение добавленой заявки.
     * 1) MemTracker - обьект класса хранилища.
     * Item - пустая заявка.
     * EditItem - класс редактирования заявки.
     * Input - mock-обьект.
     * Класс имеет зависимость от класса Scanner,
     * т.е. от ввода данных с консоли поэтому
     * за счет полиморфизма, заменяли на реализация этого
     * интерфейса класс StubInput, который имитировал
     * пользовательский ввод с консоли.
     * 2) Настройки заглушки статический метод when():
     * input.ask - методы из EditItem, вызываеться 3 раза подряд,
     * принимают String -(any(String.class)) и возвращают
     * соответсвующие аргументы - (thenReturn(id, replacedName,
     * replacedDesc)) используемые в execute().
     * Аргументы thenReturn() идут друг за другом, в зависимости
     * от количества вызывов ask().
     * 3) execute(input, tracker) - тестируемый метод у которого
     * много зависимостей.
     */
    @Test
    public void whenEditThenExecute() {
        MemTracker tracker = new MemTracker();
        Item previous = new Item("", "");
        tracker.add(previous);
        String replacedName = "Name 1";
        String replacedDesc = "Description 1";
        EditItem edit = new EditItem(2, "Редактировать заявку.");
        String id = previous.getId();
        ConsoleInput input = mock(ConsoleInput.class);
        when(input.ask(any(String.class))).thenReturn(id, replacedName, replacedDesc);
        edit.execute(input, tracker);
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    /**
     * Удаление заявки по id
     */
    @Test
    public void whenDeleteThenExecute() {
        MemTracker tracker = new MemTracker();
        Item one = new Item("1", "1");
        Item two = new Item("2", "2");
        Item three = new Item("3", "3");
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        String id = one.getId();
        ConsoleInput input = mock(ConsoleInput.class);
        when(input.ask(any(String.class))).thenReturn(id);
        new MenuTracker.DeleteItem(3, "Удалить заявку.").execute(input, tracker);
        List<Item> itemList = Arrays.asList(two, three);
        assertThat(tracker.findAll(), is(itemList));
    }

    /**
     * Проверка поиска заявки по id
     */
    @Test
    public void whenFindByIdThenExecute() {
        MemTracker tracker = new MemTracker();
        Item one = new Item("1", "1");
        Item two = new Item("2", "2");
        tracker.add(one);
        tracker.add(two);
        String id = two.getId();
        ConsoleInput input = mock(ConsoleInput.class);

        when(input.ask(any(String.class))).thenReturn(id);
        new MenuTracker.FindItemById(4, "Найти заявку по id.").execute(input, tracker);
        assertThat(tracker.findById(id), is(two));
    }

    /**
     * Проверка поиска по имени
     */
    @Test
    public void whenFindByNameThenExecute() {
        MemTracker tracker = new MemTracker();
        Item one = new Item("1", "1");
        Item two = new Item("2", "2");
        tracker.add(one);
        tracker.add(two);
        ConsoleInput input = mock(ConsoleInput.class);

        FindItemByName findItemByName = new FindItemByName(5, "Найти заявку по имени.");

        when(input.ask(any(String.class))).thenReturn("1");

        findItemByName.execute(input, tracker);
        assertThat(tracker.findByName("1").get(0), is(one));
    }

}
