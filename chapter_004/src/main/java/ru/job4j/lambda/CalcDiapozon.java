package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CalcDiapozon {

    public List<Double> diaposon(int start, int end, Function<Double, Double> func) {
        List<Double> numbers = new ArrayList<>();
        for (double i = start; i < end; i++) {
            numbers.add(func.apply(i));
        }
        return numbers;
    }


    public static void main(String[] args) {
        CalcDiapozon calcDiapozon = new CalcDiapozon();
        List<Double> result = calcDiapozon.diaposon(5,8, x -> 2 * x + 1);
        System.out.println(result);
        //result.forEach(System.out::println);

        List<Double> result1 = calcDiapozon.diaposon(5,8, x -> Math.pow(x, 2D));
        System.out.println(result1);
        //result1.forEach(System.out::println);

        List<Double> result2 = calcDiapozon.diaposon(5,8, x -> Math.log(x));
        System.out.println(result2);
    }
}