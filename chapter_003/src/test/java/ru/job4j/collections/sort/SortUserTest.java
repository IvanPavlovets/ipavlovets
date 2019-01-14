package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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
}
