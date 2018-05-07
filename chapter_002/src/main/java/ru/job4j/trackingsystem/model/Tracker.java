package ru.job4j.trackingsystem.model;

import java.util.Random;

/**
 * Класс - являеться хранилищем заявок
 * и осуществляет основные операции взоимодеяствия с заявками Item.
 */
public class Tracker {
    /**
     * хранилище заявок.
     */
    private Item[] items = new Item[10];

    /**
     * указатель ячейки добавляемой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Метод добавления заявки в хранилище.
     * При добавлении генерируеться случайный id.
     * @param item - добовляемая заявка.
     * @return - обьект заявки добавляемый в хранилище.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод редактирования заявки.
     * Заменяет ячейку в массиве item
     * найденую по id.
     * Вновь вставленой заявке присваеваеться новый id если еще не создан.
     * @param id - аргумент сравниваеться с id элементов массива items.
     * @param newItem - новый обьект массива items который замещает найденый id.
     */
    public void replace(String id, Item newItem) {
        for (int i = 0; i != this.position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                if (newItem.getId() == null) {
                    newItem.setId(this.generateId());
                }
                items[i] = newItem;
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
     * @param id - аргумент сравниваеться с id элементов массива items.
     */
    public void delete(String id) {
        if (this.position != 0) {
            Item[] buffer = new Item[this.position - 1];
            for (int i = 1; i != this.position; i++) {
                buffer[i - 1] = this.items[i - 1];
                if (this.items[i - 1].getId().equals(id)) {
                    System.arraycopy(this.items, i, buffer, i - 1, this.position - i);
                    break;
                }
            }
            this.position--;
            for (int i = 0; i < this.items.length; i++) {
                if (i < this.position) {
                    this.items[i] = buffer[i];
                } else {
                    this.items[i] = null;
                }
            }
        }
    }

    /**
     * Метод возвращает список всех заявок.
     * Возвращаемое количество заявок соответсвует
     * текущему положению указателя добавленых элементов.
     * В цикле происходит копирование основного массива
     * в массив result.
     * @return - список всех заявок.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
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
     * @param key - аргумент сравниваеться с именами
     * элементов массива items.
     * @return - массив совпавших элементов.
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[this.position];
        int i = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                temp[i++] = item;
            }
        }
        Item[] result = new Item[i];
        for (int j = 0; j < result.length; j++) {
            result[j] = temp[j];
        }
        return result;
    }

    /**
     * Метод возвращает обьект заявки по id.
     * Проверяет в цикле все элементы массива items
     * сравнивая id элемента с аргументом String id.
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
     * @return - уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

}

