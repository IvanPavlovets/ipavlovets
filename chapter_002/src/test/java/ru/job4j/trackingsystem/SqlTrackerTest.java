package ru.job4j.trackingsystem;

import org.hamcrest.Matchers;
import org.junit.Test;
import ru.job4j.trackingsystem.model.Item;
import ru.job4j.trackingsystem.tracker.ConnectionRollback;
import ru.job4j.trackingsystem.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Test TrackerSQL.
 *
 * @version 1.0.
 * @since 24.11.2018.
 */
public class SqlTrackerTest {
    /**
     * Метод создает соединение для нужд тестов.
     *
     * @return Connection
     */
    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Тест проверяет создание обьекта item с применением метода откатывания изменений в обьекте Connection.
     * тоесть обьект item создаеться в виртуальной БД (в памяти) и потом вызываеться метод rollback()
     * и состояние откатываеться назад до вызова метода createItem().
     *
     * @throws Exception
     */
    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    /**
     * Тест проверяет соеденение с БД.
     */
    @Test
    public void checkConnection() {
        SqlTracker sql = new SqlTracker();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void whenAddItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("Test Item", "Test description");
            tracker.add(item);
            assertThat(item.getName(), is("Test Item"));
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("For delete", "This is item for delete test");
            tracker.add(item);
            tracker.delete(item.getId());
            assertNull(tracker.findById(item.getId()));
        }
    }

    @Test
    public void whenFindById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("Name", "Description of find by id test");
            item = tracker.add(item);
            Item result = tracker.findById((item.getId()));
            assertThat(result.equals(item), is(true));
        }
    }

    @Test
    public void whenFindByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Имя1", "Описание1", new Date().getTime()));
            tracker.add(new Item("Имя2", "Описание2", new Date().getTime()));
            tracker.add(new Item("Имя2", "Описание3", new Date().getTime()));
            List<Item> list = tracker.findByName("Имя2");
            assertThat(list.size(), is(2));
            assertThat(list.get(0).getDescription(), Matchers.isOneOf("Описание2", "Описание3"));
            assertThat(list.get(1).getDescription(), Matchers.isOneOf("Описание2", "Описание3"));
        }
    }

    @Test
    public void whenReplaceByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item one = new Item("Name 1", "Description 1");
            Item two = new Item("Name 2", "Description 2");
            tracker.add(one);
            tracker.replace(one.getId(), two);
            assertThat(tracker.findByName("Name 2"), is(notNullValue()));
        }
    }

    @Test
    public void findByAllTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item one = new Item("Name 1", "Description 1", new Date().getTime());
            Item two = new Item("Name 2", "Description 2", new Date().getTime());
            tracker.add(one);
            tracker.add(two);
            assertThat(tracker.findAll(), is(notNullValue()));
        }
    }
}
