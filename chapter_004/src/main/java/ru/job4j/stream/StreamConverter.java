package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConverter {
    List<Integer> matrixListToList(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(
                e -> e.stream()).collect(Collectors.toList()
        );
    }

    List<Integer> matrixArrayToList(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(
                i -> Stream.of(i)).collect(Collectors.toList()
        );
    }
}
