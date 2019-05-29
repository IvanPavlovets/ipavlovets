package ru.job4j.collections.task;

import org.junit.Test;
import ru.job4j.collections.sort.SortUser;
import ru.job4j.collections.sort.User;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.List;


public class DepartStoreTest {

//    @Test
//    public void wnenInvokeDepartCheckThanReturnFullCodeDepartArray() {
//        DepartStore departStore = new DepartStore();
//        String[] codeDepartArr = new String[]{"K1/SK1", "K1/SK2", "K1/SK1/SSK1",
//                "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
//        String[] expected = new String[]{"K2/SK1", "K1/SK1", "K1/SK2", "K1", "K2", "K1/SK1/SSK2",
//                "K1/SK1/SSK1", "K2/SK1/SSK1", "K2/SK1/SSK2"};
//        assertThat(departStore.departCheck(codeDepartArr), is(expected));
//    }
//
//    @Test
//    public void wnenInvokeSortByIncreaseThanReturnFullCodeDepartArraySortedByIncrease() {
//        DepartStore departStore = new DepartStore();
//        String[] codeDepartArr = new String[]{"K1/SK1", "K1/SK2", "K1/SK1/SSK1",
//                "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
//        String[] expected = new String[]{"K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2", "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2"};
//        assertThat(departStore.sortByIncrease(codeDepartArr), is(expected));
//    }
//
//    @Test
//    public void wnenInvokeSortByDecreaseThanReturnFullCodeDepartArraySortedByDecrease() {
//        DepartStore departStore = new DepartStore();
//        String[] codeDepartArr = new String[]{"K1/SK1", "K1/SK2", "K1/SK1/SSK1",
//                "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
//        String[] expected = new String[]{"K2", "K2/SK1", "K2/SK1/SSK2", "K2/SK1/SSK1", "K1", "K1/SK2", "K1/SK1", "K1/SK1/SSK2", "K1/SK1/SSK1"};
//        assertThat(departStore.sortByDecrease(codeDepartArr), is(expected));
//    }

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
        DepartStore.Org dep2 = new DepartStore.Org(Arrays.asList("k2"));
        int result = dep1.compareTo(dep2);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFirstGreaterThenSecondThenPositiveInteger() {
        DepartStore.Org dep1 = new DepartStore.Org(Arrays.asList("k2"));
        DepartStore.Org dep2 = new DepartStore.Org(Arrays.asList("k1"));
        int result = dep1.compareTo(dep2);
        int expect = 1;
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
