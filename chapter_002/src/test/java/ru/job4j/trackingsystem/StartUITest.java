package ru.job4j.trackingsystem;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.start.StartUI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
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

    private Tracker initTest() {
        return new Tracker();
    }

    /**
     * Метод эмулирует вывод пунктов меню в консоль.
     * @return - строка пунктов меню.
     */
    public String menuPtrn() {
        StringBuilder menu = new StringBuilder();
        menu.append("\nМеню.\r\n");
        menu.append("0 - Добавить новую заявку\r\n");
        menu.append("1 - Показать все заявки\r\n");
        menu.append("2 - Редактировать заявку\r\n");
        menu.append("3 - Удалить заявку\r\n");
        menu.append("4 - Найти заявку по id\r\n");
        menu.append("5 - Найти заявки по имени\r\n");
        menu.append("6 - Выйти из программы\r\n");
        return String.valueOf(menu);
    }

    /**
     * В тест методе происходит проверка пункта меню по номеру 0 - "Добавить новую заявку" и проверяються
     * внутрений метод createItem().
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = initTest();
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * В тест методе происходит проверка пункта меню по номеру 1 - "Показать все заявки" и проверяються
     * внутрений метод showItems().
     */
    @Test
    public void whenUserWantSeeAllItemsThenTrackerShowHimAllItems() {
        //устанавливаем поток ввода в память
        this.loadOutput();
        // создаём Tracker
        Tracker tracker = initTest();
        //Напрямую добавляем заявки
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menuPtrn())
                        .append("------------ Все заявки системы --------------\r\n")
                        .append("Имя: test name1 Описание: desc1\r\n")
                        .append("Имя: test name2 Описание: desc2\r\n")
                        .append(menuPtrn())
                        .append("Выход из системы!")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
        // возвращаем обратно стандартный вывод в консоль.
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
        // создаём Tracker
        Tracker tracker = initTest();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
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
        // создаём Tracker
        Tracker tracker = initTest();
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
     * В тест методе происходит проверка пункта меню по номеру 4 - "Найти заявку по id" и проверяються
     * внутрений метод findItemById().
     */
    @Test
    public void whenUserWantFindItemByIdThenTrackerShowHimThisItem() {
        //устанавливаем поток ввода в память
        this.loadOutput();
        // создаём Tracker
        Tracker tracker = initTest();
        //Напрямую добавляем заявки
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        // id искомой заявки
        String id = item1.getId();
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"4", id, "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menuPtrn())
                        .append("------------ Поиск заявки по id --------------\r\n")
                        .append("Найденная заявка: test name1\r\n")
                        .append(menuPtrn())
                        .append("Выход из системы!")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
        // возвращаем обратно стандартный вывод в консоль.
        this.backOutput();
    }

    /**
     * В тест методе происходит проверка пункта меню по номеру 5 - "Найти заявку по имени" и проверяються
     * внутрений метод findItemByName().
     */
    @Test
    public void whenUserWantFindItemByNameThenTrackerShowHimThisItem() {
        //устанавливаем поток ввода в память
        this.loadOutput();
        // создаём Tracker
        Tracker tracker = initTest();
        //Напрямую добавляем заявки
        Item item1 = tracker.add(new Item("test name1", "desc1"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"5", "test name2", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menuPtrn())
                        .append("------------ Поиск заявки по имени --------------\r\n")
                        .append("Имя: test name2 Описание: desc2\r\n")
                        .append(menuPtrn())
                        .append("Выход из системы!")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
        // возвращаем обратно стандартный вывод в консоль.
        this.backOutput();
    }
}
