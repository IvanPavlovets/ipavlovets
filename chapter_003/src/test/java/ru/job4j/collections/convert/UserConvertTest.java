package ru.job4j.collections.convert;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    /**
     * Тест проверяет конвертацию (метод process) списка обьектов User
     * в Map с ключом Integer id и соответвующем ему User.
     */
    @Test
    public void whenInputListThenOutputMap() {
        UserConvert convert = new UserConvert();

        List<User> input = Arrays.asList(new User(10, "Ivan", "Zneleznogorsk"),
                                         new User(20, "Petr", "Briansk"),
                                         new User(30, "Vadim", "Moscow"));

        Map<Integer, User> expect = new HashMap<>();
        for (User user : input) {
            expect.put(user.getId(), user);
        }

        HashMap<Integer, User> result = convert.process(input);

        assertThat(result, is(expect));

    }
}
