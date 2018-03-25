package ru.job4j.loop;

public class Counter {

    private int count;

    /**
     * Метод вычисляет сумму четныx чисел в диапазоне от start до finish.
     * @param start - минимальное значение.
     * @param finish - максимальное значение.
     * @return сумму четныx чисел диапозона.
     */
    public int add(int start, int finish){
        for (int i = start; i <= finish ; i++) {
            if (i%2 == 0) {
                count += i;
            }
        }
        return count;
    }

}
