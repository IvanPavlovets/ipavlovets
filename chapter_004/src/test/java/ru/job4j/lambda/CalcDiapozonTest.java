package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalcDiapozonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        CalcDiapozon function = new CalcDiapozon();
        List<Double> result = function.diaposon(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        CalcDiapozon function = new CalcDiapozon();
        List<Double> result = function.diaposon(5,8, x -> Math.pow(x, 2D));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        CalcDiapozon function = new CalcDiapozon();
        List<Double> result = function.diaposon(5,8, x -> Math.log(x));
        List<Double> expected = Arrays.asList(Math.log(5), Math.log(6), Math.log(7));
        assertThat(result, is(expected));
    }
}
