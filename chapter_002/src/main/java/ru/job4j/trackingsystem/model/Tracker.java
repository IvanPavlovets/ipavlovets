package ru.job4j.trackingsystem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс - являеться хранилищем заявок
 * и осуществляет основные операции взоимодеяствия с заявками Item.
 */
public class Tracker {
    /**
     * хранилище заявок.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * указатель ячейки добавляемой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Метод добавления заявки в хранилище.
     * При добавлении генерируеться случайный id.
     *
     * @param item - добовляемая заявка.
     * @return - обьект заявки добавляемый в хранилище.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(this.position++, item);
        return item;
    }

    /**
     * Метод редактирования заявки.
     * Заменяет ячейку в массиве item
     * найденую по id.
     * Вновь вставленой заявке присваеваеться новый id если еще не создан.
     *
     * @param id      - аргумент сравниваеться с id элементов массива items.
     * @param newItem - новый обьект массива items который замещает найденый id.
     */
    public void replace(String id, Item newItem) {
        for (int i = 0; i != this.position; i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                if (newItem.getId() == null) {
                    newItem.setId(this.generateId());
                }
                items.set(i, newItem);
            }
        }
    }

    /**
     * Метод удаления заявки.
     * В первом цикле происходит заполнение массива buffer заявками из items,
     * с длинной buffer равной -1 заявка массива items.
     * В условии происходит поиск ячейки по id и смещение
     * всех значений справа от удаляемого элемента на одну ячейку
     * с помощью System.arrayCopy().
     * Во втором цикле происходит копирование значений массива buffer
     * обратно в items за вычетом удаленной ячеки, остальные пустые
     * элементы items заполняються null.
     * указатель заявок position декрементируеться на еденицу.
     *
     * @param id - аргумент сравниваеться с id элементов массива items.
     */
    public void delete(String id) {
        this.items.remove(this.findById(id));
    }

    /**
     * Метод возвращает список всех заявок.
     * Возвращаемое количество заявок соответсвует
     * текущему положению указателя добавленых элементов.
     * В цикле происходит копирование основного массива
     * в массив result.
     *
     * @return - список всех заявок.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            result.add(item);
        }
        return result;
    }

    /**
     * Метод возвращает список заявок по имени.
     * Проверяет в цикле все элементы массива items,
     * сравнивая name с аргументом метода String key.
     * Элементы, у которых совпадает name,
     * копирует в промежуточный массив temp
     * с длинной равной указателю заявок position.
     * Во втором цикле заполняеться массив result
     * длинна котрова равна кол-ву найденых совподений
     * в первом цикле.
     *
     * @param key - аргумент сравниваеться с именами
     *            элементов массива items.
     * @return - массив совпавших элементов.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод возвращает обьект заявки по id.
     * Проверяет в цикле все элементы массива items
     * сравнивая id элемента с аргументом String id.
     *
     * @param id - аргумент сравниваеться с id элементов массива items.
     * @return - совпавший по id обьект item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерации id для новой заявки.
     * Сумма из сгенерированного случайного числа
     * и текущего времени в милисекундах
     * переводиться в тип String.
     *
     * @return - уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

}

