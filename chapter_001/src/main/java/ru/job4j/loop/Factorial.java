package ru.job4j.loop;

/**
 * Класс вычисления факториала числа.
 */
public class Factorial {

    /**
     * Метод вычисляет факториал целого положительно числа.
     * @param n - аргумент, целое число.
     * @return факториал аргумента.
     */
    public int calc(int n){
        int count = 1;
        for (int i = 1; i <= n; i++) {
            count *= i;
        }
        return count;
    }
}
