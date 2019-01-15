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
                Arrays.asList(new User("A", 2),
                        new User("I", 1),
                        new User("H", 4),
                        new User("P", 5),
                        new User("B", 3))));

        Set<User> expected = new TreeSet<User>();
        expected.add(new User("I", 1));
        expected.add(new User("A", 2));
        expected.add(new User("B", 3));
        expected.add(new User("H", 4));
        expected.add(new User("P", 5));
        assertThat(result.toArray(), is(expected.toArray()));
    }

    @Test
    public void wnenInputListWhenReturnListSortedByNameLengh() {
        List<User> resultList = new ArrayList<User>();
        resultList.addAll(new SortUser().sortNameLengh(
                Arrays.asList(new User("AA", 1),
                        new User("BBB", 3),
                        new User("PPPPP", 4),
                        new User("I", 2),
                        new User("HHHH", 5))));

        List<User> expectedList = new ArrayList<User>();
        expectedList.add(new User("I", 2));
        expectedList.add(new User("AA", 1));
        expectedList.add(new User("BBB", 3));
        expectedList.add(new User("HHHH", 5));
        expectedList.add(new User("PPPPP", 4));
        assertThat(resultList.toArray(), is(expectedList.toArray()));
    }


    @Test
    public void wnenInputListWhenReturnListSortedByNameAndByAge() {
        List<User> userList2 = new ArrayList<User>();
        userList2.addAll(new SortUser().sortByAllFields(
                Arrays.asList(
                        new User("Сергей", 25),
                        new User("Иван", 30),
                        new User("Сергей", 20),
                        new User("Иван", 25))));

        List<User> expectedList = new ArrayList<User>();
        expectedList.add(new User("Иван", 25));
        expectedList.add(new User("Иван", 30));
        expectedList.add(new User("Сергей", 20));
        expectedList.add(new User("Сергей", 25));
        assertThat(userList2.toArray(), is(expectedList.toArray()));
    }


}
