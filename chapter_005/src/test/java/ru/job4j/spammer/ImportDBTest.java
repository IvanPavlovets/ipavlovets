package ru.job4j.spammer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ImportDBTest {
    /**
     * Папка для работы с времеными файлами
     */
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    /**
     * Тест проверяет соеденение с БД.
     */
    @Test
    public void checkConnection() throws Exception {
        ImportDB db = new ImportDB();
        assertThat(db.initConnection(), is(true));
    }

    /**
     * В методе создаеться и заполняеться временый файл source а также коллекция users.
     * В методе load() происходит загрузка коллекции с обьектами User(name, email) в БД.
     * БД создает каждому обьекту свой id.
     * В конце идет сравнение возвращеной коллекции методом load() и коллекции users.
     * @throws Exception
     */
    @Test
    public void whenLoadUsers() throws Exception {
        File source = folder.newFile("dump1.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("Petr Arsentev;parsentev@yandex.ru;");
            out.println("Ivan Ivanov;iivanov@gmail.com;");
            out.println("Ivan Pavlovets;ivan150287@gmail.com");
        }

        ImportDB db = new ImportDB(source.getAbsolutePath());
        List<User> users = List.of(
                new User("Petr Arsentev", "parsentev@yandex.ru"),
                new User("Ivan Ivanov", "iivanov@gmail.com"),
                new User("Ivan Pavlovets", "ivan150287@gmail.com")
        );
        assertThat(db.load(), is(users));
    }

}
