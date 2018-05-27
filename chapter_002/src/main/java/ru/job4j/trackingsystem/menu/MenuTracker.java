package ru.job4j.trackingsystem.menu;

import ru.job4j.trackingsystem.model.Item;
import ru.job4j.trackingsystem.model.Tracker;
import ru.job4j.trackingsystem.io.Input;

/**
 * Класс содержит действие меню - редактировать заявку.
 */
class EditItem implements UserAction {
    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заменяемой заявки");
        if (tracker.findById(id) == null) {
            System.out.println("Нет такой заявки!");
        }
        String name = input.ask("Введите имя новой заявки :");
        String desc = input.ask("Введите описание новой заявки :");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Редактировать заявку.");
    }
}

/**
 * Класс содержит действие меню - найти заявку по имени.
 */
class FindItemByName implements UserAction {
    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки");
        for (Item item : tracker.findByName(name)) {
            System.out.println("Имя: " + item.getName() + " Описание: " + item.getDescription());
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Найти заявку по имени.");
    }
}

/**
 * Класс содержит действия меню - добавить новую заявку, показать все заявки.
 */
public class MenuTracker {

    /**
     * Переменная хранит экземпляр системы ввода/вывода.
     */
    private Input input;

    /**
     * Переменная хранит экземпляр класса хранилища
     * и всех утилитных методов трекинговой системы.
     */
    private Tracker tracker;

    /**
     * массив содержит все действия системы.
     */
    private UserAction[] actions = new UserAction[6];

    public final int[] getActionsNumbers() {
        int[] ranges = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            ranges[i] = i;
        }
        return ranges;
    }

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Выводит информацию про событие
     * Метод инициализирует внутренее событие
     */
    public void fillActions() {
        // создаем экземпляр внутренего класса
        // и инициализируем его передаными обьектами.
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = new MenuTracker.FindItemById();
        this.actions[5] = new FindItemByName();
    }

    /**
     * Метод выполняет действия которые выбрал пользователь.
     * Возвращает действие которое храниться в массиве.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод печатает меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Внутрений класс определяет внтутренюю логику действия меню по добовлению заявки.
     */
    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        /**
         * Выполняет действие по добовлению заявки.
         * @param input - обьект интерфейса ввода.
         * @param tracker - базовый класс всех утилитных методов действий трекинговой системы.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя новой заявки :");
            String desc = input.ask("Введите описание новой заявки :");
            tracker.add(new Item(name, desc));
        }

        /**
         * сообщает пользователю о том что данный пункт меню делает.
         * @return - строка формируеться по шаблону
         * принимающиму в качестве значений передоваемые данные
         * для сложения 2х строк
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новую заявку.");
        }
    }

    /**
     * Внутрений класс содержит внтутренюю логику меню по удалению заявки.
     */
    private class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        /**
         * Выполняет действие по удалению заявки.
         * @param input - обьект интерфейса ввода.
         * @param tracker - базовый класс всех утилитных методов действий трекинговой системы.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки");
            System.out.println("Заявка с именем: " + tracker.findById(id).getName() + " удалена!");
            tracker.delete(id);
        }

        /**
         * сообщает пользователю о том что данный пункт меню делает.
         * @return - строка формируеться по шаблону
         * принимающиму в качестве значений передоваемые данные
         * для сложения 2х строк
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку.");
        }
    }

    /**
     * Внутрений класс действия меню по показу всех заявок.
     */
    private static class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        /**
         * Выполняет действие по показу всех заявок.
         * @param input - обьект интерфейса ввода.
         * @param tracker - базовый класс всех утилитных методов действий трекинговой системы.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s. %s", item.getName(), item.getDescription(), item.getId()));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Показать все заявки системы.");
        }
    }

    /**
     * Статический Внутрений класс реализует действия меню по поиску заявки по id.
     */
    private static class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        /**
         * Выполняет действие по поиску заявки по id.
         * @param input - обьект интерфейса ввода.
         * @param tracker - базовый класс всех утилитных методов действий трекинговой системы.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки");
            System.out.println("Найденная заявка: " + tracker.findById(id).getName());
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по id.");
        }
    }

}
