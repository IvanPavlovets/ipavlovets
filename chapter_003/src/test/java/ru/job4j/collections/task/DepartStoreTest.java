package ru.job4j.collections.task;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DepartStoreTest {

    @Test
    public void whenMissed() {
        DepartStore deps = new DepartStore();
        List<String> input = Arrays.asList("k1/sk1"); // вход

        List<DepartStore.Org> expect = Arrays.asList(
                new DepartStore.Org(Arrays.asList("k1")),
                new DepartStore.Org(Arrays.asList("k1", "sk1"))

        );
        List<DepartStore.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAsc() {
        DepartStore deps = new DepartStore();
        List<String> input = Arrays.asList("k1/sk1", "k2");
        List<DepartStore.Org> expect = Arrays.asList(
                new DepartStore.Org(Arrays.asList("k1")),
                new DepartStore.Org(Arrays.asList("k1", "sk1")),
                new DepartStore.Org(Arrays.asList("k2"))
        );
        List<DepartStore.Org> result = deps.sortAsc(deps.convert(input));
        assertThat(result, is(expect));
    }

    @Test
    public void whenDesc() {
        DepartStore deps = new DepartStore();
        List<String> input = Arrays.asList("k1/sk1", "k2");
        List<DepartStore.Org> expect = Arrays.asList(
                new DepartStore.Org(Arrays.asList("k2")),
                new DepartStore.Org(Arrays.asList("k1")),
                new DepartStore.Org(Arrays.asList("k1", "sk1"))
        );
        List<DepartStore.Org> result = deps.sortDesc(deps.convert(input));
        assertThat(result, is(expect));
    }

    @Test
    public void whenFirstLessThenSecondThenNegativeInteger() {
        DepartStore.Org dep1 = new DepartStore.Org(Arrays.asList("k1"));
        DepartStore.Org dep2 = new DepartStore.Org(Arrays.asList("k1/sk1", "k2"));
        int result = dep1.compareTo(dep2);
        int expect = Math.negateExact(Math.abs(result));
        assertThat(result, is(expect));
    }

    @Test
    public void whenFirstGreaterThenSecondThenPositiveInteger() {
        DepartStore.Org dep1 = new DepartStore.Org(Arrays.asList("k1/sk1", "k2"));
        DepartStore.Org dep2 = new DepartStore.Org(Arrays.asList("k1"));
        int result = dep1.compareTo(dep2);
        int expect = Math.abs(result);
        assertThat(result, is(expect));
    }

    @Test
    public void whenFirstEqualSecondThenZeroInteger() {
        DepartStore.Org dep1 = new DepartStore.Org(Arrays.asList("k2"));
        DepartStore.Org dep2 = new DepartStore.Org(Arrays.asList("k2"));
        int result = dep1.compareTo(dep2);
        int expect = 0;
        assertThat(result, is(expect));
    }

}
