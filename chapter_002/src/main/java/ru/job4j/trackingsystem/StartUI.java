package ru.job4j.trackingsystem;

/**
 * Класс с системой ввода/вывода для работы с пользовательм.
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа демонстрации всех заявок хранилища.
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа удаления заявки из хранилища.
     */
    private static final String DELETE = "3";

    /**
     * Константа поиска заявки по id.
     */
    private static final String FIND_ITEM_BY_ID = "4";

    /**
     * Константа поиска заявки по имени.
     */
    private static final String FIND_ITEM_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Список пунктов меню.
     */
    private final String[] menuPattern;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        menuPattern = new String[]{"Добавить новую заявку",
                "Показать все заявки",
                "Редактировать заявку",
                "Удалить заявку",
                "Найти заявку по id",
                "Найти заявки по имени",
                "Выйти из программы"};
    }


    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
                this.showItems();
            } else if (FIND_ITEM_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_ITEM_BY_NAME.equals(answer)) {
                this.findItemByName();
                //Добавить остальные действия системы по меню.
            } else if (EXIT.equals(answer)) {
                System.out.println("Выход из системы!");
                exit = true;
            }
        }
    }

    /**
     * Метод поиска заявки по имени в хранилище.
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки");
        for (Item item : this.tracker.findByName(name)) {
            System.out.println("Имя : " + item.getName() + " Описание : " + item.getDescription());
        }
    }

    /**
     * Метод поиска заявки по id в хранилище.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки");
        System.out.println("Найденная заявка : " + this.tracker.findById(id).getName());
    }

    /**
     * Метод удаления заявки из хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки");
        System.out.println("Заявка " + this.tracker.findById(id).getName() + " удалена");
        this.tracker.delete(id);
    }

    /**
     * Метод редактирования заявки в хранилище.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки");
        String name = this.input.ask("Введите имя новой заявки :");
        String desc = this.input.ask("Введите описание новой заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод показывает все заявки в хранилище.
     */
    private void showItems() {
        System.out.println("------------ Все заявки системы --------------");
        for (Item item : this.tracker.findAll()) {
            System.out.println("Имя : " + item.getName() + " Описание : " + item.getDescription());
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Новая заявка с getId : " + item.getId());
    }

    private void showMenu() {
        System.out.println("\nМеню.");
        for (int i = 0; i <= 6; i++) {
            System.out.println(i + " - " + menuPattern[i]);
        }
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

