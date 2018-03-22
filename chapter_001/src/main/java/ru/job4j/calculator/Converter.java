package ru.job4j.calculator;

/**
 * Конвертор валюты.
 */
public class Converter {

    /**
     * Конверируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value){
        return value / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конверируем евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRuble(int value){
        return value * 70;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли.
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }

}
