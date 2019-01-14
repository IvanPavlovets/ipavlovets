package ru.job4j.collections.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<User> sort(List<User> list) {
        Set<User> userSet = new TreeSet<>();
        userSet.addAll(list);
        return userSet;
    }
}
