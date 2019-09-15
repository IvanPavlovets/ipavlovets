package ru.job4j.task;

import java.util.Arrays;

public class StreamApi {
    int streamModify(int[] arr) {
        return Arrays.stream(arr).filter(i -> (i % 2) == 0).map(i -> i * i).reduce(0, Integer::sum);
    }

    int[] makeEvenNumbers(int[] arr) {
        return Arrays.stream(arr).filter(i -> (i % 2) == 0).toArray();
    }

    int[] mekeSquareEvenNumbers(int[] arr) {
        return Arrays.stream(arr).filter(i -> (i % 2) == 0).map(i -> i * i).toArray();
    }

}
