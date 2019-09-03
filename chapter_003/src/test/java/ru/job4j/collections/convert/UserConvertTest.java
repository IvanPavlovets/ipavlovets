package ru.job4j.collections.convert;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<User> input = List.of(new User(10, "Ivan", "Zneleznogorsk"),
                new User(20, "Petr", "Briansk"),
                new User(30, "Vadim", "Moscow")
        );

        Map<Integer, User> expect = input.stream().collect(Collectors.toMap(
                o -> o.getId(),
                o -> o
                )
        );
        HashMap<Integer, User> result = convert.process(input);

        assertThat(result, is(expect));

    }
}
