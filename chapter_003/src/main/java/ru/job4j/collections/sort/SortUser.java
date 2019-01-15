package ru.job4j.collections.sort;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> list) {
        return new TreeSet<User>(list);
    }

    /**
     * Метод сортировки по длине имени.
     * @param list
     * @return - отсортированный по имени список.
     */
    public List<User> sortNameLengh(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() > o2.getName().length() ? 1 : -1;
            }
        });
        return list;
    }

    /**
     * Метод сортировки по обоим полям,
     * сначала сортировка по имени в лексикографическом порядке,
     * потом по возрасту.
     * @param list
     * @return - отсортированный список.
     */
    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int rst = o1.getName().compareTo(o2.getName());
                return rst != 0 ? rst : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
