package ru.job4j.coffeemachine;

import java.util.Arrays;

public class CoffeeMachine {
    int[] coins;
    /**
     * Сумма сдачи.
     */
    int change;
    /**
     * Количество монет номиналом 10.
     */
    int num10;
    /**
     * Количество монет номиналом 5.
     */
    int num5;
    /**
     * Количество монет номиналом 2.
     */
    int num2;
    /**
     * Количество монет номиналом 1.
     */
    int num1;

    /**
     * Метод возврашает сдачу после покупки кофе.
     * @param value купюра номиналом 50, 100 и так далее.
     * @param price цена кофе.
     * @return сдача наименьшим количеством монет номиналом 1, 2, 5, 10.
     */
    int[] changes(int value, int price) {
        if (value < price) {
           throw new NotEnoughMoneyException("Недостаточно денег на кофе!");
        }
        change = value - price;
        num10 = change / 10;
        num5 = (change - (num10 * 10)) / 5;
        num2 = (change - ((num10 * 10) + (num5 * 5))) / 2;
        num1 = (change - ((num10 * 10) + (num5 * 5) + (num2 * 2))) / 1;
        coins = new int[num1 + num2 + num5 + num10];
        for (int i = 0; i < num10; i++) {
            coins[i] = 10;
        }
        for (int i = 0; i < num5; i++) {
            coins[i + num10] = 5;
        }
        for (int i = 0; i < num2; i++) {
            coins[i + num10 + num5] = 2;
        }
        for (int i = 0; i < num1; i++) {
            coins[i + num10 + num5 + num2] = 1;
        }
        return coins;
    }

}
