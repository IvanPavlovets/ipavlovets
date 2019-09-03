package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void wnenInputListWhenReturnSet() {
        Set<User> result = new TreeSet<User>();
        result.addAll(new SortUser().sort(
                List.of(new User("A", 2),
                        new User("I", 1),
                        new User("H", 4),
                        new User("P", 5),
                        new User("B", 3))));

        Set<User> expected = new TreeSet<User>();
        expected.addAll(Set.of(
                new User("I", 1),
                new User("A", 2),
                new User("B", 3),
                new User("H", 4),
                new User("P", 5)
        ));
        assertThat(result.toArray(), is(expected.toArray()));
    }

    @Test
    public void wnenInputListWhenReturnListSortedByNameLengh() {
        List<User> resultList = new SortUser().sortNameLengh(
                Arrays.asList(new User("AA", 1),
                        new User("BBB", 3),
                        new User("PPPPP", 4),
                        new User("I", 2),
                        new User("HHHH", 5))
        );

        List<User> expectedList = List.of(
                new User("I", 2),
                new User("AA", 1),
                new User("BBB", 3),
                new User("HHHH", 5),
                new User("PPPPP", 4)
        );
        assertThat(resultList.toArray(), is(expectedList.toArray()));
    }


    @Test
    public void wnenInputListWhenReturnListSortedByNameAndByAge() {
        List<User> userList2 = new SortUser().sortByAllFields(
                Arrays.asList(
                        new User("Сергей", 25),
                        new User("Иван", 30),
                        new User("Сергей", 20),
                        new User("Иван", 25))
        );

        List<User> expectedList = List.of(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)
        );
        assertThat(userList2, is(expectedList));
    }


}
