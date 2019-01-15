package ru.job4j.collections.sort;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int i = 0;
        while (i < Math.min(left.length(), right.length())) {
            int eq = Character.compare(left.charAt(i), right.charAt(i));
            if (eq != 0) {
                return left.charAt(i) - right.charAt(i);
            }
            i++;
        }
        return left.length() - right.length();
    }
}
