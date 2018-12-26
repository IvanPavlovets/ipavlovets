package ru.job4j.collections.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : array) {
            for (int i : ints) {
                list.add(i);
            }
        }
        return list;
    }
}

