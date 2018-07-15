package ru.job4j.trackingsystem;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import ru.job4j.trackingsystem.model.Item;
import ru.job4j.trackingsystem.model.Tracker;
import ru.job4j.trackingsystem.start.StartUI;
import ru.job4j.trackingsystem.io.Input;
import ru.job4j.trackingsystem.io.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

public class StartUITest {

    /**
     * поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Метод устанавлевает поток вывода до начала теста.
     */
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Метод устанавлевает стандартный поток вывода после теста.
     */
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Метод эмулирует вывод пунктов меню в консоль.
     * @return - строка пунктов меню.
     */
    public String menuPtrn() {
        StringJoiner menu = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        menu.add("0. Добавить новую заявку.");
        menu.add("1. Показать все заявки системы.");
        menu.add("2. Редактировать заявку.");
        menu.add("3. Удалить заявку.");
        menu.add("4. Найти заявку по id.");
        menu.add("5. Найти заявку по имени.");
        return String.valueOf(menu);
    }

    /**
     * В тест методе происходит проверка пункта меню по номеру 0 - "Добавить новую заявку." и проверяються
     * внутрений метод createItem().
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * В тест методе происходит проверка пункта меню по номеру 1 - "Показать все заявки." и проверяються
     * внутрений метод showItems().
     */
    @Test
    public void whenUserWantSeeAllItemsThenTrackerShowHimAllItems() {
        this.loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        String idItem1 = item1.getId();
        String idItem2 = item2.getId();
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menuPtrn())
                        .append(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("test name1. desc1. " + idItem1)
                                .add("test name2. desc2. " + idItem2))
                        .toString()
                )
        );
        this.backOutput();
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
        Tracker tracker = new Tracker();  //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * В тест методе происходит проверка пункта меню по номеру 3 - "Удалить заявку" и проверяються
     * внутрений метод deleteItem().
     */
    @Test
    public void whenUserDeleteItemThenTrackerDoIt() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Input input = new StubInput(new String[]{"3", item1.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
    }

    /**
     * В тест методе происходит проверка пункта меню по номеру 4 - "Найти заявку по id" и проверяються
     * внутрений метод findItemById().
     */
    @Test
    public void whenUserWantFindItemByIdThenTrackerShowHimThisItem() {
        this.loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        String id = item1.getId();
        Input input = new StubInput(new String[]{"4", id, "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menuPtrn())
                        .append(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("Найденная заявка: test name1"))
                        .toString()
                )
        );
        this.backOutput();
    }

    /**
     * В тест методе происходит проверка пункта меню по номеру 5 - "Найти заявку по имени" и проверяються
     * внутрений метод findItemByName().
     */
    @Test
    public void whenUserWantFindItemByNameThenTrackerShowHimThisItem() {
        this.loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Input input = new StubInput(new String[]{"5", "test name2", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menuPtrn())
                        .append(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("Имя: test name2 Описание: desc2"))
                        .toString()
                )
        );
        this.backOutput();
    }
}
