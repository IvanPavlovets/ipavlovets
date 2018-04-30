package ru.job4j.trackingsystem;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.start.StartUI;

public class StartUITest {

    /**
     * В тест методе происходит проверка пункта меню по номеру 0 - "Добавить новую заявку" и проверяються
     * внутрений метод createItem().
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * В тест методе происходит проверка пункта меню по номеру 3 - "Удалить заявку" и проверяються
     * внутрений метод deleteItem().
     */
    @Test
    public void whenUserDeleteItemThenTrackerDoIt() {
        Tracker tracker = new Tracker();     // создаём Tracker
        //Напрямую добавляем заявки
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
    }

    /**
     * В тесте происходит проверка пункта меню по номеру 2 - "Редактировать заявку" и внутренего метода replace
     * осуществляющего замену первого элемента хранилища tracker с пустой заявкой new Item()
     * на заявку созданую посредством эмуляции пользовательского ввода в
     * new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"}).
     *
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
}
