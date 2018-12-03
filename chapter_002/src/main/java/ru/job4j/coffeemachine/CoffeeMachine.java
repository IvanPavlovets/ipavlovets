package ru.job4j.coffeemachine;

import java.util.Arrays;

public class CoffeeMachine {
    /**
     * Сумма сдачи.
     */
    private int change;

    /**
     * Массив номиналов монет.
     * Каждому индексу соответсвует свой номинал монет
     * [0] - 10-ки, [1] - 5-ки, [2] - 2-ки, [3] - 1-цы.
     */
    private int[] cartridge = new int[4];

    /**
     * Метод возврашает сдачу после покупки кофе.
     * @param value купюра номиналом 50, 100 и так далее.
     * @param price цена кофе.
     * @return сдача наименьшим количеством монет номиналом 1, 2, 5, 10.
     */
    int[] changes(int value, int price) {
        int[] coins;
        if (value < price) {
           throw new NotEnoughMoneyException("Недостаточно денег на кофе!");
        }
        change = value - price;
        cartridge[0] = change / 10;
        cartridge[1] = (change - (cartridge[0] * 10)) / 5;
        cartridge[2] = (change - ((cartridge[0] * 10) + (cartridge[1] * 5))) / 2;
        cartridge[3] = (change - ((cartridge[0] * 10) + (cartridge[1] * 5) + (cartridge[2] * 2))) / 1;

        coins = new int[cartridge[3] + cartridge[2] + cartridge[1] + cartridge[0]];
        for (int i = 0; i < cartridge[0]; i++) {
            coins[i] = 10;
        }
        for (int i = 0; i < cartridge[1]; i++) {
            coins[i + cartridge[0]] = 5;
        }
        for (int i = 0; i < cartridge[2]; i++) {
            coins[i + cartridge[0] + cartridge[1]] = 2;
        }
        for (int i = 0; i < cartridge[3]; i++) {
            coins[i + cartridge[0] + cartridge[1] + cartridge[2]] = 1;
        }
        return coins;
    }

}
