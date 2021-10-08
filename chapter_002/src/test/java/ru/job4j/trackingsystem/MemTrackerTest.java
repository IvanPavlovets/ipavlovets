package ru.job4j.trackingsystem;

import org.junit.Test;
import ru.job4j.trackingsystem.model.Item;
import ru.job4j.trackingsystem.model.MemTracker;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MemTrackerTest {

    /**
     * Проверка метода метод findById.
     */
    @Test
    public void whenCallFindByIdMethodThenTrackerGetItem() {
        MemTracker tracker = new MemTracker();
        Item item1 = new Item("1 task", "this is 1 task", 123L);
        Item item2 = new Item("2 task", "this is 2 task", 123L);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }

    /**
     * Проверка метода метод findByName.
     */
    @Test
    public void whenCallFindByNameMethodThenTrackerHas3EqualNames() {
        MemTracker tracker = new MemTracker();
        Item item1 = new Item("12 task", "this is 1 task", 123L);
        Item item2 = new Item("12 task", "this is 2 task", 123L);
        Item item3 = new Item("12 task", "this is 3 task", 123L);
        Item item4 = new Item("22 task", "this is 3 task", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        List<Item> itemArr = Arrays.asList(item1, item2, item3);
        assertThat(tracker.findByName("12 task"), is(itemArr));
    }

    /**
     * Проверка метода delete.
     */
    @Test
    public void whenDeleteItemThenTrackerHasNotThisItem() {
        MemTracker tracker = new MemTracker();
        Item item1 = new Item("1 task", "this is 1 task", 123L);
        Item item2 = new Item("2 task", "this is 2 task", 123L);
        Item item3 = new Item("3 task", "this is 3 task", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> itemList = Arrays.asList(item1, item3);
        tracker.delete(item2.getId());
        assertThat(tracker.findAll(), is(itemList));
    }

    /**
     * Проверка метода add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    /**
     * Проверка метода replace.
     *
     * Добавляем заявку в трекер. Теперь в объекте проинициализирован id:
     * tracker.add(previous)
     * Создаем новую заявку:
     * Item next = new Item("test2", "testDescription2", 1234L)
     * Проставляем старый id из previous, который был сгенерирован выше:
     * next.setId(previous.getId())
     * Обновляем заявку в трекере:
     * tracker.replace(previous.getId(), next)
     * Проверяем, что заявка с таким id имеет новые имя test2:
     * assertThat()
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        MemTracker tracker = new MemTracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
}
