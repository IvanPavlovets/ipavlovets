package ru.job4j.coffeemachine;

import org.junit.Test;
import ru.job4j.gameofchess.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {

    @Test
    public void whenPriceThirtyFiveThenFifteenGiveBack() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] actual = coffeeMachine.changes(50, 35);
        int[] expected = {10, 5};
        assertThat(actual, is(expected));
    }

    @Test
    public void whenPriceThirtyFourThenSixteenGiveBack() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] actual = coffeeMachine.changes(50, 34);
        int[] expected = {10, 5, 1};
        assertThat(actual, is(expected));
    }

    @Test
    public void whenPriceThirtySixThenFourteenGiveBack() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] actual = coffeeMachine.changes(50, 36);
        int[] expected = {10, 2, 2};
        assertThat(actual, is(expected));
    }

}
